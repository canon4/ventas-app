package com.deleciasexpress.ventas_app.repository;

import com.deleciasexpress.ventas_app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombreUsuarioAndPassword(String nombreUsuario, String password);

}
