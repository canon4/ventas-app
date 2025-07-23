package com.deleciasexpress.ventas_app.controllers;

import com.deleciasexpress.ventas_app.model.Pago;
import com.deleciasexpress.ventas_app.service.PagoService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    PagoService pagoService;

    @GetMapping()
    public List<Pago> listarPagos(){
        return pagoService.listarPagos();
    }

    @GetMapping("/{id}")
    public Optional<Pago> buscarPagoById(@PathVariable Long id){
        return pagoService.buscarPagoById(id);
    }

    @PostMapping()
    public Pago agregarPago(@RequestBody Pago pago){
        return pagoService.agregarPago(pago);
    }
    @DeleteMapping("/{id}")
    public void eliminarPago (@PathVariable Long id){
        pagoService.eliminarPago(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pago> editarPago(@PathVariable Long id, @RequestBody Pago pagoEditado){
        return pagoService.editarPago(id, pagoEditado);
    }

}
