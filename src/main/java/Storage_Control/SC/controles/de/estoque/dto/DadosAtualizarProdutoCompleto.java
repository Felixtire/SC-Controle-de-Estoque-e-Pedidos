package Storage_Control.SC.controles.de.estoque.dto;

import Storage_Control.SC.controles.de.estoque.entity.StatusProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizarProdutoCompleto(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotNull
        BigDecimal preco,
        @NotNull
        StatusProduto statusProduto,
        @NotNull
        Integer estoque) {
}
