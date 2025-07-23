package com.deleciasexpress.ventas_app.controllers;

import com.deleciasexpress.ventas_app.model.DetallePedido;
import com.deleciasexpress.ventas_app.model.EstadoPedido;
import com.deleciasexpress.ventas_app.model.Pedido;
import com.deleciasexpress.ventas_app.repository.PedidoRepository;
import com.deleciasexpress.ventas_app.service.PedidoService;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping()
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.agregarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminarpedido(@PathVariable Long id){
        pedidoService.eliminarPedidio(id);
    }

    @GetMapping()
    public List<Pedido> listarPedidos(){
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido>  obtenerPedidoById(@PathVariable Long id){
       return pedidoService.obtenerpedidoById(id);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Pedido> editarPedido(@PathVariable Long id, @RequestBody Pedido pedido){
        return pedidoService.editarPedido(id,pedido);
    }

}
