package com.deleciasexpress.ventas_app.repository;

import com.deleciasexpress.ventas_app.model.Pago;
import com.deleciasexpress.ventas_app.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Long> {
}
