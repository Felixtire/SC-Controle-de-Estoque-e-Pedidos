package Storage_Control.SC.controles.de.estoque.entity.produto;

import Storage_Control.SC.controles.de.estoque.dto.entrada.DadosCadastroProduto;
import Storage_Control.SC.controles.de.estoque.entity.StatusProduto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "produto")
@Table(name = "produtos")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(nullable = false)
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private StatusProduto statusProduto;
    private Integer estoque;


    public Produto( String nome, BigDecimal preco, StatusProduto statusProduto, Integer estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque= estoque;
        this.statusProduto = statusProduto;

    }


    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.estoque= dados.estoque();
        this.statusProduto = dados.statusProduto();
    }
}
