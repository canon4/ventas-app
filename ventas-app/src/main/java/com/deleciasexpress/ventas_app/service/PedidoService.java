package com.deleciasexpress.ventas_app.service;

import com.deleciasexpress.ventas_app.model.*;
import com.deleciasexpress.ventas_app.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    ProductoService productoService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    DetallePedidoService detallePedidoService;

    public ResponseEntity<Pedido> agregarPedido(Pedido pedido){

        pedido.setFechaHora(LocalDateTime.now());
        pedido.setEstado(EstadoPedido.PENDIENTE);


        // Establecer la relación inversa en cada detalle
        for (DetallePedido detalle : pedido.getDetallePedidos()) {
            Long productoId = detalle.getProducto().getId();
            Producto producto = productoService.obtnerProductoById(productoId).get();
            detalle.setProducto(producto);
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setTotal(calcularTotal(detalle));

            Long usuarioId = pedido.getUsuario().getId();
            Usuario usuario = usuarioService.obtenerUsuarioById(usuarioId).get();
            pedido.setUsuario(usuario);
            detalle.setPedido(pedido);
        }

        Pedido guardado = pedidoRepository.save(pedido);
        return ResponseEntity.ok(guardado);
    }

    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerpedidoById(Long id){
        return pedidoRepository.findById(id);
    }

    public void eliminarPedidio(Long id){
        pedidoRepository.deleteById(id);

    }

    public ResponseEntity<Pedido> editarPedido(Long id, Pedido pedidoActualizado){
        Optional<Pedido> pedidoTrget = obtenerpedidoById(id);

        if (pedidoTrget.isPresent()){
            Pedido pedido = pedidoTrget.get();
            pedido.setFechaHora(LocalDateTime.now());
            pedido.setMesa(pedidoActualizado.getMesa());
            pedido.setEstado(pedidoActualizado.getEstado());

            pedido.getDetallePedidos().clear();
            for (DetallePedido nuevoDetalle : pedidoActualizado.getDetallePedidos()) {
                nuevoDetalle.setPedido(pedido); // relación inversa
                pedido.getDetallePedidos().add(nuevoDetalle);
            }

            return agregarPedido(pedido);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public double calcularTotal(DetallePedido detallePedido ){
        return detallePedido.getPrecioUnitario() * detallePedido.getCantidad();
    }
}
