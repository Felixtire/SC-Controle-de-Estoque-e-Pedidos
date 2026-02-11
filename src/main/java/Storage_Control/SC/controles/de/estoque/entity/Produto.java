package Storage_Control.SC.controles.de.estoque.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "produto")
@Table(name = "produtos")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private Status status;
    private List<ItemPedido> itens;
    private BigDecimal valorTotal;


    public Produto(Date data, Status status, List<ItemPedido> itens, BigDecimal valorTotal) {
        this.data = data;
        this.status = status;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

}
