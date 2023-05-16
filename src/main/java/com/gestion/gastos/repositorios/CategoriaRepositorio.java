package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
