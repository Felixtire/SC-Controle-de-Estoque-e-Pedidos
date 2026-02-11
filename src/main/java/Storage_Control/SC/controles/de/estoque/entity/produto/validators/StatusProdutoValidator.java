package Storage_Control.SC.controles.de.estoque.entity.produto.validators;

import Storage_Control.SC.controles.de.estoque.entity.StatusProduto;
import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;
import org.springframework.stereotype.Component;

@Component
public class StatusProdutoValidator implements ProdutoValidations {

    @Override
    public String validarProtuto(Produto produto) {
        if (produto.getStatusProduto()== StatusProduto.INATIVO) {
            return "Produto inativo";// lançar uma exception personalizada
        }
        return null;

    }
}
