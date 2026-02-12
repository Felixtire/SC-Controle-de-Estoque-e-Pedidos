package Storage_Control.SC.controles.de.estoque.dto;

import Storage_Control.SC.controles.de.estoque.entity.StatusProduto;
import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.util.List;

public record ProdutosListadosDto(String nome, BigDecimal preco, StatusProduto statusProduto, Integer estoque) {
    public ProdutosListadosDto(Produto produto) {
        this(produto.getNome(), produto.getPreco(), produto.getStatusProduto(), produto.getEstoque());
    }
}
