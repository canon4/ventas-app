package com.deleciasexpress.ventas_app.controllers;

import com.deleciasexpress.ventas_app.dto.LoginRequestDto;
import com.deleciasexpress.ventas_app.dto.LoginResponseDTO;
import com.deleciasexpress.ventas_app.model.Usuario;
import com.deleciasexpress.ventas_app.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuario();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> listarUsuarioById(@PathVariable Long id){
        return usuarioService.obtenerUsuarioById(id);
    }

    @PostMapping()
    public Usuario agregarUsuario(@RequestBody @Valid Usuario usuario){
        return usuarioService.agregarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        return usuarioService.actualizarUsuario(id,usuarioActualizado);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loguinRequestDto){
        Optional<Usuario> usuario= usuarioService.findByNombreUsuarioAndPassword(loguinRequestDto.getNombreUsuario(), loguinRequestDto.getPassword());

        if (usuario.isPresent()){
            String rol = usuario.get().getRol();
            return ResponseEntity.ok(new LoginResponseDTO(rol));
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales Incorrectas");
        }

    }

}
