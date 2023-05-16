package com.gestion.gastos.servicios;

import com.gestion.gastos.entidades.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria agregarCategoria(Categoria categoria);
    Categoria actualizarCategoria(Categoria categoria);
    List<Categoria> obtenerCategorias();
    Categoria obtenerCategoria(long id);
    void eliminarCategoria(long id);

}
