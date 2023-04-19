package com.gestion.gastos.servicios.Impl;

import com.gestion.gastos.entidades.Usuario;
import com.gestion.gastos.entidades.UsuarioRol;
import com.gestion.gastos.repositorios.RolRepositorio;
import com.gestion.gastos.repositorios.UsuarioRepositorio;
import com.gestion.gastos.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRols) throws Exception {
        Usuario usuariolocal = usuarioRepositorio.findByUsername(usuario.getUsername());
        if(usuariolocal != null){
            throw new Exception("El usuario ya existe");
        }else{
            for(UsuarioRol rol : usuarioRols){
                rolRepositorio.save(rol.getRol());
            }
            usuario.getUsuarioRol().addAll(usuarioRols);
            usuariolocal = usuarioRepositorio.save(usuario);
        }
        return usuariolocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepositorio.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long userId) {
        usuarioRepositorio.deleteById(userId);
    }
}
