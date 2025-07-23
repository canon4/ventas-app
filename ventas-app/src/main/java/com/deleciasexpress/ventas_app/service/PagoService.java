package com.deleciasexpress.ventas_app.service;

import com.deleciasexpress.ventas_app.model.Pago;
import com.deleciasexpress.ventas_app.model.Pedido;
import com.deleciasexpress.ventas_app.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {
    @Autowired
    PagoRepository pagoRepository;
    @Autowired
    PedidoService pedidoService;

    public Pago agregarPago(Pago pago){
        Optional<Pedido> pedido = pedidoService.obtenerpedidoById(pago.getPedido().getId());
        
        return pagoRepository.save(pago);
    }

    public List<Pago> listarPagos(){
        return pagoRepository.findAll();
    }

    public void eliminarPago(Long id){
        pagoRepository.deleteById(id);
    }

    public Optional<Pago> buscarPagoById(Long id){
        return pagoRepository.findById(id);
    }

    public ResponseEntity editarPago(Long id, Pago pagoEditado){
        Optional<Pago> pagoTarget = pagoRepository.findById(id);

        if (pagoTarget.isPresent()){
            Pago pago = pagoTarget.get();
            pago.setTipoPago(pago.getTipoPago());
            return ResponseEntity.ok(pago);
        }else {
           return ResponseEntity.notFound().build();
        }
    }

//    public double calcularMonto(Pago pago){
//        Optional<Pedido> pedido =pedidoService.obtenerpedidoById(pago.getPedido().getId());
//
//    }

}
