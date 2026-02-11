package Storage_Control.SC.controles.de.estoque.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.jpa.boot.spi.Bootstrap;

import java.math.BigDecimal;

@Entity(name = "pedido")
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private BigDecimal preco;
    private Integer estoque;
    private StatusPedido status;

    public Pedido(Long id, String nome, BigDecimal preco, Integer estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }
}
