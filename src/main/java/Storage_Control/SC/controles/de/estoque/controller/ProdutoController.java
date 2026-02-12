package Storage_Control.SC.controles.de.estoque.controller;

import Storage_Control.SC.controles.de.estoque.dto.DadosAtualizarProduto;
import Storage_Control.SC.controles.de.estoque.dto.DadosAtualizarProdutoCompleto;
import Storage_Control.SC.controles.de.estoque.dto.DadosCadastroProduto;
import Storage_Control.SC.controles.de.estoque.dto.ProdutosListadosDto;
import Storage_Control.SC.controles.de.estoque.service.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @PostMapping
    public ResponseEntity cadastrarProduto(@RequestBody @Valid DadosCadastroProduto dados) {
        var produto = produtoService.cadastrarProduto(dados);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutosListadosDto>> listarProdutos(@PageableDefault(
            page = 0,
            size = 10,
            sort = "nome",
            direction = Sort.Direction.ASC
    ) Pageable pageable) {
        var page = produtoService.listarProdutos(pageable);
        return ResponseEntity.ok(page);
    }

    @PatchMapping
    public ResponseEntity atualizarProduto(@RequestBody DadosAtualizarProduto dados) {
        var produto = produtoService.atualizar(dados);
        return ResponseEntity.ok().body(produto);
    }

    @PutMapping
    public ResponseEntity atualizarProdutoCompleto(@RequestBody @Valid DadosAtualizarProdutoCompleto dados) {
        var produto = produtoService.atualizarCompleto(dados);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProduto(@PathVariable @Positive Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.ok().body("Produto deletado com sucesso");


    }
}
