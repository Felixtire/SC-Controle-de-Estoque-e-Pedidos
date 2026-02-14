package Storage_Control.SC.controles.de.estoque.service;

import Storage_Control.SC.controles.de.estoque.dto.entrada.CarrinhoDeCompras;
import Storage_Control.SC.controles.de.estoque.dto.entrada.ItemProdutoDto;
import Storage_Control.SC.controles.de.estoque.entity.ItemPedido;
import Storage_Control.SC.controles.de.estoque.entity.Pedido;
import Storage_Control.SC.controles.de.estoque.entity.StatusPedido;
import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;
import Storage_Control.SC.controles.de.estoque.entity.produto.validators.pedidos.PedidosValidations;
import Storage_Control.SC.controles.de.estoque.repository.ItemPedidoRepository;
import Storage_Control.SC.controles.de.estoque.repository.PedidoRepository;
import Storage_Control.SC.controles.de.estoque.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class PedidosService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private List<PedidosValidations> validations;

    @Transactional
    public Pedido cadastrarPedido(CarrinhoDeCompras carrinho) {

        var pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.CRIADO);

        List<ItemPedido> itens = new ArrayList<>();

        BigDecimal totalPedido = BigDecimal.ZERO;

        for (ItemProdutoDto dto : carrinho.produto()) {
            var produto = produtoRepository.findByNomeIgnoreCase(dto.nomeProduto())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + dto.nomeProduto()));


            var item = new ItemPedido();

            item.setPedido(pedido);
            item.setProduto(produto);
            item.setQuantidade(dto.quantidade());
            item.setPrecoUnitario(produto.getPreco());


            itens.add(item);
            BigDecimal valorTotalItem = produto.getPreco().multiply(BigDecimal.valueOf(dto.quantidade()));

          totalPedido = totalPedido.add(valorTotalItem);

          validations.forEach(v-> v.validarPedido(item));



        }
        pedido.setItens(itens);

        pedido.setValorTotal(totalPedido);


        return pedidoRepository.save(pedido);

    }









}
