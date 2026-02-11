package Storage_Control.SC.controles.de.estoque.repository;

import Storage_Control.SC.controles.de.estoque.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
