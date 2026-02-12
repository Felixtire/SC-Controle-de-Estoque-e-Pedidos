package Storage_Control.SC.controles.de.estoque.dto.entrada;

import Storage_Control.SC.controles.de.estoque.entity.StatusProduto;

import java.math.BigDecimal;

public record DadosAtualizarProduto(String nome, BigDecimal preco, StatusProduto statusProduto, Integer estoque) {
}
