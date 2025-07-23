package com.deleciasexpress.ventas_app.service;

import com.deleciasexpress.ventas_app.dto.DetallePedidoUpdateDTO;
import com.deleciasexpress.ventas_app.model.DetallePedido;
import com.deleciasexpress.ventas_app.model.Producto;
import com.deleciasexpress.ventas_app.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoService {

    @Autowired
    DetallePedidoRepository detallePedidoRepository;
    @Autowired
    ProductoService productoService;

    public ResponseEntity<DetallePedido> editarDetallePedido(Long id, DetallePedidoUpdateDTO detallepedidoUpdateDTO){
        DetallePedido detalle = detallePedidoRepository.findById(id).get();

        Producto producto = productoService.obtnerProductoById(detallepedidoUpdateDTO.getProductoId()).get();

        detalle.setProducto(producto);
        detalle.setCantidad(detallepedidoUpdateDTO.getCantidad());
        detalle.setPrecioUnitario(producto.getPrecio());
        detalle.setTotal(producto.getPrecio() * detallepedidoUpdateDTO.getCantidad());

        return ResponseEntity.ok(detallePedidoRepository.save(detalle));
    }

}
