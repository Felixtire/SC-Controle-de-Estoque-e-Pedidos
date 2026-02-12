package Storage_Control.SC.controles.de.estoque.service;

import Storage_Control.SC.controles.de.estoque.dto.DadosCadastroProduto;
import Storage_Control.SC.controles.de.estoque.dto.ProdutosListadosDto;
import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;
import Storage_Control.SC.controles.de.estoque.entity.produto.validators.ProdutoValidations;
import Storage_Control.SC.controles.de.estoque.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private List<ProdutoValidations> validations;


    @Transactional
    public Produto cadastrarProduto(DadosCadastroProduto dados) {
        Produto produto = new Produto(dados);

        validations.stream().map(v-> v.validarProtuto(produto)).toList();


        return produtoRepository.save(produto);
    }


    public Page<ProdutosListadosDto> listarProdutos(Pageable pageable) {
       return produtoRepository.findAll(pageable)
               .map(ProdutosListadosDto::new);
                

    }
}
