package com.deleciasexpress.ventas_app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class DetallePedidoUpdateDTO {

    @Min(1)
    private Integer cantidad;
    @NotNull
    private Long productoId;

    public @NotNull Long getProductoId() {
        return productoId;
    }

    public void setProductoId(@NotNull Long productoId) {
        this.productoId = productoId;
    }

    public @Min(1) Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(@Min(1) Integer cantidad) {
        this.cantidad = cantidad;
    }

}
