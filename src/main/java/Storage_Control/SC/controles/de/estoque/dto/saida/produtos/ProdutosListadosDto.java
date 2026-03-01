package Storage_Control.SC.controles.de.estoque.dto.saida.produtos;

import Storage_Control.SC.controles.de.estoque.entity.StatusProduto;
import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;

import java.math.BigDecimal;

public record ProdutosListadosDto(Long id,String nome, BigDecimal preco, StatusProduto statusProduto, Integer estoque) {
    public ProdutosListadosDto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getStatusProduto(), produto.getEstoque());
    }
}
