package Storage_Control.SC.controles.de.estoque.repository;

import Storage_Control.SC.controles.de.estoque.entity.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    public Optional <Produto> findByNome(String nome);
}
