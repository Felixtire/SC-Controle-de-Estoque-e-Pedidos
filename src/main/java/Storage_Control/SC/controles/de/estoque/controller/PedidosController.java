package Storage_Control.SC.controles.de.estoque.controller;

import Storage_Control.SC.controles.de.estoque.dto.entrada.CarrinhoDeCompras;
import Storage_Control.SC.controles.de.estoque.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @PostMapping
    public ResponseEntity cadastrarPedido(@RequestBody CarrinhoDeCompras carrinho, UriComponentsBuilder uriComponentsBuilder){
        var pedido = pedidosService.cadastrarPedido(carrinho);
        var uri = uriComponentsBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();

        return ResponseEntity.created(uri).body(pedido);


    }

    @GetMapping
    public ResponseEntity listarPedidos(@PageableDefault(size = 10) Pageable pageable){
        var pedidos = pedidosService.listarPedidos(pageable);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPedidosPorId(@RequestParam Long id){
        var pedido = pedidosService.listarPedidoPorId(id);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping
    public ResponseEntity deletarPedido(@RequestParam Long id){
        pedidosService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

}
