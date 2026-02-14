package Storage_Control.SC.controles.de.estoque.entity.produto.validators.pedidos;

import Storage_Control.SC.controles.de.estoque.entity.ItemPedido;
import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;
import Storage_Control.SC.controles.de.estoque.exception.PedidoException;
import org.springframework.stereotype.Component;

@Component
public class ValidarEstoque implements PedidosValidations{

    @Override
    public void validarPedido(ItemPedido itemPedido) {
        Produto produto = itemPedido.getProduto();

        if (itemPedido.getQuantidade()> produto.getEstoque()){
            throw new PedidoException("Quantidade solicitada excede o estoque disponível");
        }
        if (itemPedido.getQuantidade() <= 0) {
            throw new PedidoException("A quantidade do pedido deve ser maior que zero");
        }
        if (itemPedido.getPedido() == null) {
            throw new PedidoException("O pedido associado ao item do pedido não pode ser nulo");
        }

    }
}
