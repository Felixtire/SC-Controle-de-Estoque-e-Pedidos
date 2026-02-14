package Storage_Control.SC.controles.de.estoque.entity.produto.validators.pedidos;

import Storage_Control.SC.controles.de.estoque.entity.ItemPedido;
import org.hibernate.validator.constraints.ru.INN;
import org.springframework.stereotype.Component;

@Component
public class DebitarEstoque implements PedidosValidations{

    @Override
    public void validarPedido(ItemPedido itemPedido) {

        var produto = itemPedido.getProduto();
        var quantidade = itemPedido.getQuantidade();

        var estoqueAtual =  produto.getEstoque();
        var novoEstoque = estoqueAtual - quantidade;

        produto.setEstoque(novoEstoque);

    }
}
