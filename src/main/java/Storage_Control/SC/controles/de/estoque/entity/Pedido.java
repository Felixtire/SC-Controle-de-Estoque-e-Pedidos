package Storage_Control.SC.controles.de.estoque.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.jpa.boot.spi.Bootstrap;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(name = "pedido")
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal valorTotal;
    private LocalDateTime dataPedido;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens;

    public Pedido(Long id, String nome, BigDecimal preco, Integer estoque, LocalDateTime dataPedido, StatusPedido status, BigDecimal valorTotal, List<ItemPedido> itens) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.itens = itens;
        this.dataPedido = dataPedido;
        this.status = status;
    }
}
