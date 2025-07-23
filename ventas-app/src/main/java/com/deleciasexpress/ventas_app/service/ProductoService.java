package com.deleciasexpress.ventas_app.service;

import com.deleciasexpress.ventas_app.model.Producto;
import com.deleciasexpress.ventas_app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> obtnerProductoById(Long id){
        return productoRepository.findById(id);
    }

    public Producto agregarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public void eliminarProductoById(Long id){
        productoRepository.deleteById(id);
    }

    public ResponseEntity<Producto> actualizarProducto(Long id, Producto productoActualizado){
        Optional<Producto> productoTarget = obtnerProductoById(id);
        if (productoTarget.isPresent()){
            Producto producto = productoTarget.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());
            producto.setStockMinimo(productoActualizado.getStockMinimo());

            return ResponseEntity.ok(agregarProducto(producto));
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}

