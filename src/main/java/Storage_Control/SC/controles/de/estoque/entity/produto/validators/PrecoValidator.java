package Storage_Control.SC.controles.de.estoque.entity.produto.validators;

import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PrecoValidator implements ProdutoValidations
{

    @Override
    public void validarProtuto(Produto produto) {

        if (produto.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException( "O preço do produto deve ser maior que zero."); //lancar exceção personalizada
        }

    }
}
