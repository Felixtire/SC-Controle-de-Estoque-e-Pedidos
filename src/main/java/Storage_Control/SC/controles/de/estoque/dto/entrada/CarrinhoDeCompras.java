package Storage_Control.SC.controles.de.estoque.dto.entrada;

import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;

import java.math.BigDecimal;
import java.util.List;

public record CarrinhoDeCompras( List<ItemProdutoDto> produto) {

}
