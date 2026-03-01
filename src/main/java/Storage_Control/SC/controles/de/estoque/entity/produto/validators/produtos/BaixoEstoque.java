package Storage_Control.SC.controles.de.estoque.entity.produto.validators.produtos;

import Storage_Control.SC.controles.de.estoque.dto.saida.produtos.BaixoEstoqueDto;
import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;
import Storage_Control.SC.controles.de.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class BaixoEstoque implements ProdutoInfo {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    public BaixoEstoqueDto infoProduto() {
        var baixo= produtoRepository.countByEstoqueLessThanEqual(10);

        return new BaixoEstoqueDto(baixo);

    }
}
