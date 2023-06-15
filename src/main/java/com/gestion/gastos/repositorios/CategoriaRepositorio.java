package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
    List<Categoria> findAllByUsuario(Usuario usuario);
}
