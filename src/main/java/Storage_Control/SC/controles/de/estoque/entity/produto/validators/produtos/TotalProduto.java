package Storage_Control.SC.controles.de.estoque.entity.produto.validators.produtos;

import Storage_Control.SC.controles.de.estoque.dto.saida.produtos.ProdutosAllInfoDto;
import Storage_Control.SC.controles.de.estoque.dto.saida.produtos.ProdutosListadosDto;
import Storage_Control.SC.controles.de.estoque.dto.saida.produtos.Total;
import Storage_Control.SC.controles.de.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TotalProduto implements ProdutoInfo {

    @Autowired
    private ProdutoRepository repository;


    public Total infoProduto() {

       var total =  repository.count();
        return new Total(total);
    }



}
