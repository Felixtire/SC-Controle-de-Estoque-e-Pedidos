package Storage_Control.SC.controles.de.estoque.dto.saida;

import Storage_Control.SC.controles.de.estoque.entity.Pedido;
import Storage_Control.SC.controles.de.estoque.entity.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PedidosListadosDto(

        Long id,

        BigDecimal valorTotal,

        LocalDateTime dataPedido,

        StatusPedido statusPedido
) {

    public PedidosListadosDto(Pedido pedido){
        this(pedido.getId(), pedido.getValorTotal(), pedido.getDataPedido(), pedido.getStatus());
    }
}
