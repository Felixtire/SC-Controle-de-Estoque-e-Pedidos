package Storage_Control.SC.controles.de.estoque.entity.produto.validators;

import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;
import Storage_Control.SC.controles.de.estoque.exception.ProdutoException;
import org.springframework.stereotype.Component;

@Component
public class EstoqueValidators implements ProdutoValidations {
    @Override
    public void validarProtuto(Produto produto) {

        if (produto.getEstoque() == null || produto.getEstoque() < 0) {
            throw new ProdutoException("O estoque deve ser um número inteiro não negativo."); //lançar uma exceção para indicar que o valor é inválido
        }



    }


    }



