package Storage_Control.SC.controles.de.estoque.entity;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class ItemPedido {

    private Produto produto;

    private Integer quantidade;

   private BigDecimal precoUnitario;;  // copiado do produto no momento da compra


    public ItemPedido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

}
