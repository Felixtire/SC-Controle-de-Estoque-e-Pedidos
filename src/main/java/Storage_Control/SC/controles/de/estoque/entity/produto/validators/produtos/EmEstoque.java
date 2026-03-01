package Storage_Control.SC.controles.de.estoque.entity.produto.validators.produtos;

import Storage_Control.SC.controles.de.estoque.dto.saida.produtos.EmEstoqueDto;
import Storage_Control.SC.controles.de.estoque.entity.StatusProduto;
import Storage_Control.SC.controles.de.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmEstoque implements ProdutoInfo{

    @Autowired
    private ProdutoRepository produtoRepository;


    public EmEstoqueDto infoProduto() {
       var produto =  produtoRepository.findAllByStatusProduto(StatusProduto.ATIVO);


        var emEstoque = produto.stream().count();


        return new EmEstoqueDto(emEstoque);


    }
}
