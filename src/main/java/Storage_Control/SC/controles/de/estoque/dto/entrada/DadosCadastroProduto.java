package Storage_Control.SC.controles.de.estoque.dto.entrada;

import Storage_Control.SC.controles.de.estoque.entity.StatusProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroProduto(

        @NotBlank
        String nome,
        @NotNull
        BigDecimal preco,
        @NotNull
        int estoque,
        @NotNull
        StatusProduto statusProduto) {
}


