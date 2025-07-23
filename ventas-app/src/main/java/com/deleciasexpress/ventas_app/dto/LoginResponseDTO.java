package com.deleciasexpress.ventas_app.dto;

public class LoginResponseDTO {
    private String rol;

    public LoginResponseDTO(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
