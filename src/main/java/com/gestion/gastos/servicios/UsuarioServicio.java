package com.gestion.gastos.servicios;

import com.gestion.gastos.entidades.Usuario;
import com.gestion.gastos.entidades.UsuarioRol;

import java.util.Set;

public interface UsuarioServicio {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRols) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long userId);


}
