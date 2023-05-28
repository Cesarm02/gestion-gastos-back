package com.gestion.gastos.servicios;

import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.entidades.Usuario;

import java.util.List;

public interface CategoriaService {

    Categoria agregarCategoria(Categoria categoria);
    Categoria actualizarCategoria(Categoria categoria);
    List<Categoria> obtenerCategorias(Usuario usuario);
    Categoria obtenerCategoria(long id);
    void eliminarCategoria(long id);

}
