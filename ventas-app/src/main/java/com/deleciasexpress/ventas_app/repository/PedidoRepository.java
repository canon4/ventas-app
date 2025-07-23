package com.deleciasexpress.ventas_app.repository;

import com.deleciasexpress.ventas_app.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
