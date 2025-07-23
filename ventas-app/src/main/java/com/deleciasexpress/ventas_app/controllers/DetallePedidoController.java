package com.deleciasexpress.ventas_app.controllers;

import com.deleciasexpress.ventas_app.dto.DetallePedidoUpdateDTO;
import com.deleciasexpress.ventas_app.model.DetallePedido;
import com.deleciasexpress.ventas_app.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detalles")
public class DetallePedidoController {

    @Autowired
    DetallePedidoService detallePedidoService;

    @PatchMapping("/{id}")
    public ResponseEntity<DetallePedido> editarDetallePedido(@PathVariable Long id, @RequestBody DetallePedidoUpdateDTO detallePedido){
        return detallePedidoService.editarDetallePedido(id, detallePedido);
    }
}
