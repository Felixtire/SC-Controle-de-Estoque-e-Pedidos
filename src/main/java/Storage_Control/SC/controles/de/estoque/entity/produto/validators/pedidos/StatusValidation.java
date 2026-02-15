package Storage_Control.SC.controles.de.estoque.entity.produto.validators.pedidos;

import Storage_Control.SC.controles.de.estoque.entity.ItemPedido;
import Storage_Control.SC.controles.de.estoque.entity.StatusProduto;
import Storage_Control.SC.controles.de.estoque.exception.PedidoException;
import org.springframework.stereotype.Component;

@Component
public class StatusValidation implements PedidosValidations{

    @Override
    public void validarPedido(ItemPedido itemPedido) {

        var produto = itemPedido.getProduto();

        if (produto.getStatusProduto() == StatusProduto.INATIVO){
            throw new PedidoException("Produto inativo não está disponível para venda");
        }
    }
}
