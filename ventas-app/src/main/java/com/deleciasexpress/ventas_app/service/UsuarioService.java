package com.deleciasexpress.ventas_app.service;

import com.deleciasexpress.ventas_app.model.Usuario;
import com.deleciasexpress.ventas_app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario agregarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public ResponseEntity<Usuario> actualizarUsuario(Long id, Usuario usuarioActualizado){
        Optional<Usuario>  usuarioTarget = obtenerUsuarioById(id);
        if (usuarioTarget.isPresent()){
            Usuario usuario = usuarioTarget.get();
            usuario.setNombre(usuario.getNombre());
            usuario.setNombreUsuario(usuarioActualizado.getNombreUsuario());
            usuario.setPassword(usuarioActualizado.getPassword());
            usuario.setRol(usuarioActualizado.getRol());

            return ResponseEntity.ok(agregarUsuario(usuario));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

   public Optional<Usuario> findByNombreUsuarioAndPassword(String nombreUsuario, String password){
        return usuarioRepository.findByNombreUsuarioAndPassword(nombreUsuario, password);
    }
}
