package Storage_Control.SC.controles.de.estoque.service;

import Storage_Control.SC.controles.de.estoque.dto.entrada.DadosAtualizarProduto;
import Storage_Control.SC.controles.de.estoque.dto.entrada.DadosAtualizarProdutoCompleto;
import Storage_Control.SC.controles.de.estoque.dto.entrada.DadosCadastroProduto;
import Storage_Control.SC.controles.de.estoque.dto.saida.produtos.ListaDeProdutosDto;
import Storage_Control.SC.controles.de.estoque.dto.saida.produtos.ProdutosAllInfoDto;
import Storage_Control.SC.controles.de.estoque.dto.saida.produtos.ProdutosListadosDto;
import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;
import Storage_Control.SC.controles.de.estoque.entity.produto.validators.produtos.*;
import Storage_Control.SC.controles.de.estoque.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
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

    @Autowired
    private BaixoEstoque baixoEstoque;

    @Autowired
    private EmEstoque emEstoque;

    @Autowired
    private TotalProduto totalProduto;



    @Transactional
    public Produto cadastrarProduto(DadosCadastroProduto dados) {
        Produto produto = new Produto(dados);

      validations.forEach(v-> v.validarProtuto(produto));


        return produtoRepository.save(produto);
    }


    public ListaDeProdutosDto listarProdutos(Pageable pageable) {
        var lista = produtoRepository.findAll(pageable)
                .map(ProdutosListadosDto::new);



        var baixo = baixoEstoque.infoProduto();
        var emEstoqueQtd = emEstoque.infoProduto();
        var total = totalProduto.infoProduto();

        ProdutosAllInfoDto produtosAllInfoDto = new ProdutosAllInfoDto(baixo,emEstoqueQtd,total);

        return new ListaDeProdutosDto(produtosAllInfoDto, lista);





    }
    @Transactional
    public Produto atualizar(DadosAtualizarProduto dados) {

        var produto = produtoRepository.findByNome(dados.nome())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        ;

        if (dados.nome() != null) {
            produto.setNome(dados.nome());
        }

        if (dados.statusProduto() != null) {
            produto.setStatusProduto(dados.statusProduto());
        }
        if (dados.statusProduto() == null) {
            produto.setStatusProduto(produto.getStatusProduto());
        }

        if (dados.preco() != null) {
            produto.setPreco(dados.preco());
        }

        if (dados.preco() == null) {
            produto.setPreco(produto.getPreco());
        }

        if (dados.estoque() != null) {
            produto.setEstoque(dados.estoque());
        }

        if (dados.estoque() == null) {
            produto.setEstoque(produto.getEstoque());
        }

        return produtoRepository.save(produto);


    }
    @Transactional
    public Produto atualizarCompleto(@Valid DadosAtualizarProdutoCompleto dados) {
        var produto = produtoRepository.findById(dados.id())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(dados.nome());
        produto.setStatusProduto(dados.statusProduto());
        produto.setPreco(dados.preco());
        produto.setEstoque(dados.estoque());

        return produtoRepository.save(produto);

    }
    @Transactional
    public void deletarProduto(@Positive Long id) {
        var produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoRepository.deleteById(produto.getId());
    }

    public Produto listarPorNome(String nome) {


        var produto =  produtoRepository.findByNomeContainingIgnoreCase(nome.trim()).orElseThrow(()->new RuntimeException("Produto não encontrado"));

        return produto;



    }
}