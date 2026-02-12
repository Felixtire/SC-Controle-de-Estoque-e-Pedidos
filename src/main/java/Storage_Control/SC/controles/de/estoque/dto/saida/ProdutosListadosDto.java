package Storage_Control.SC.controles.de.estoque.dto.saida;

import Storage_Control.SC.controles.de.estoque.entity.StatusProduto;
import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;

import java.math.BigDecimal;

public record ProdutosListadosDto(String nome, BigDecimal preco, StatusProduto statusProduto, Integer estoque) {
    public ProdutosListadosDto(Produto produto) {
        this(produto.getNome(), produto.getPreco(), produto.getStatusProduto(), produto.getEstoque());
    }
}
