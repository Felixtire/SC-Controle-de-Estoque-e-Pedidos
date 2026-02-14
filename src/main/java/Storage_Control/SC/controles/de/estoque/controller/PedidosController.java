package Storage_Control.SC.controles.de.estoque.controller;

import Storage_Control.SC.controles.de.estoque.dto.entrada.CarrinhoDeCompras;
import Storage_Control.SC.controles.de.estoque.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @PostMapping
    public ResponseEntity cadastrarPedido(@RequestBody CarrinhoDeCompras carrinho){
        var pedido = pedidosService.cadastrarPedido(carrinho);
        return ResponseEntity.ok(pedido);
    }

}
