package Storage_Control.SC.controles.de.estoque.service;

import Storage_Control.SC.controles.de.estoque.dto.entrada.CarrinhoDeCompras;
import Storage_Control.SC.controles.de.estoque.dto.entrada.ItemProdutoDto;
import Storage_Control.SC.controles.de.estoque.dto.saida.PedidosListadosDto;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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


    public Page<PedidosListadosDto> listarPedidos(Pageable pageable) {

        return pedidoRepository.findAll(pageable)
                .map(PedidosListadosDto :: new);

    }

    public PedidosListadosDto listarPedidoPorId(Long id) {

        var pedido = pedidoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pedido não encontrado com id: " + id));


        return new PedidosListadosDto(pedido);
    }

    public void deletarPedido(Long id) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pedido não encontrado com id: " + id));

        pedidoRepository.delete(pedido);
    }

    @Transactional
    public Pedido pagarPedido(Long id) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pedido não encontrado com id: " + id));

        if (pedido.getStatus() != StatusPedido.PAGO && pedido.getStatus() != StatusPedido.CANCELADO) {
            pedido.setStatus(StatusPedido.PAGO);
        } else {
            throw new RuntimeException("Pedido já está pago ou cancelado");
        }


        return pedidoRepository.save(pedido);

    }

    public void cancelarPedido(Long id) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pedido não encontrado com id: " + id));




        if (pedido.getStatus() != StatusPedido.CANCELADO && pedido.getStatus() != StatusPedido.PAGO) {
            pedido.setStatus(StatusPedido.CANCELADO);

            pedido.getItens().stream().forEach(itemPedido -> {
                var produto = itemPedido.getProduto();
                var quantidade = itemPedido.getQuantidade();
                reporEstoque(produto, quantidade);
            });
            pedidoRepository.save(pedido);

        } else {
            throw new RuntimeException("Pedido já está pago ou cancelado");
        }



    }
    @Transactional
    private Produto reporEstoque(Produto produto, int quantidade){
        var produtoAtualizado = produtoRepository.findByNomeIgnoreCase(produto.getNome()).orElseThrow(() -> new RuntimeException("Produto não encontrado: " + produto.getNome()));

        var estoque = produtoAtualizado.getEstoque();
        var novoEstoque = estoque + quantidade;
        produtoAtualizado.setEstoque(novoEstoque);

        return produtoRepository.save(produtoAtualizado);

    }
}
