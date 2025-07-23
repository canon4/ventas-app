package com.deleciasexpress.ventas_app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductoRequestDTO {

    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @Min(0)
    private Double precio;
    @Min(0)
    private Integer stock;
    @Min(0)
    private Integer stockMinimo;

    public @NotBlank String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotBlank String descripcion) {
        this.descripcion = descripcion;
    }

    public @Min(0) Double getPrecio() {
        return precio;
    }

    public void setPrecio(@Min(0) Double precio) {
        this.precio = precio;
    }

    public @Min(0) Integer getStock() {
        return stock;
    }

    public void setStock(@Min(0) Integer stock) {
        this.stock = stock;
    }

    public @Min(0) Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(@Min(0) Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
}
