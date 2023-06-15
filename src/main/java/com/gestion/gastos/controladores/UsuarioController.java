package com.gestion.gastos.controladores;

import com.gestion.gastos.entidades.Rol;
import com.gestion.gastos.entidades.Usuario;
import com.gestion.gastos.entidades.UsuarioRol;
import com.gestion.gastos.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        usuario.setPerfil("default.png");
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setNombre("Normal");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);

        return usuarioServicio.guardarUsuario(usuario, usuarioRoles);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioServicio.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioServicio.eliminarUsuario(usuarioId);
    }

    @GetMapping("/all")
    public ResponseEntity<?> obtenerUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        try{
            usuarios = usuarioServicio.obtenerUsuarios();
        }catch (Exception e ){
            e.printStackTrace();
        }
        return ResponseEntity.ok(usuarios);
    }


}
