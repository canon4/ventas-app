package com.deleciasexpress.ventas_app.repository;

import com.deleciasexpress.ventas_app.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
