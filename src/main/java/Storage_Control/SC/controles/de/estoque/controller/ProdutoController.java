package Storage_Control.SC.controles.de.estoque.controller;

import Storage_Control.SC.controles.de.estoque.dto.DadosCadastroProduto;
import Storage_Control.SC.controles.de.estoque.service.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;



    @PostMapping
    public ResponseEntity cadastrarProduto(@RequestBody @Valid DadosCadastroProduto dados){
        var produto = produtoService.cadastrarProduto(dados);
        return ResponseEntity.ok().body(produto);
    }



//     public ResponseEntity atualizarProduto(@RequestBody @Valid DadosAtualizarProduto dados){
//        var produto = produtoService.atualizar(dados);
//        return ResponseEntity.ok().body(produto);
//    }




}
