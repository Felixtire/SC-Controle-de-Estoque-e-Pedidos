package Storage_Control.SC.controles.de.estoque.repository;

import Storage_Control.SC.controles.de.estoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
