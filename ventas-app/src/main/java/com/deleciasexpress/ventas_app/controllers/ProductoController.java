package com.deleciasexpress.ventas_app.controllers;

import com.deleciasexpress.ventas_app.model.Producto;
import com.deleciasexpress.ventas_app.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping()
    public List<Producto> listarProductos(){
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> obtenerProductoById(@PathVariable Long id){
        return productoService.obtnerProductoById(id);
    }

    @PostMapping()
    public Producto agregarproducto(@RequestBody @Valid Producto producto ){
        return productoService.agregarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable @Valid Long id){
        productoService.eliminarProductoById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Producto> ActualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado ){
        return productoService.actualizarProducto(id, productoActualizado);
    }

}
