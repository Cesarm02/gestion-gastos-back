package com.gestion.gastos.servicios.Impl;

import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.entidades.Usuario;
import com.gestion.gastos.repositorios.CategoriaRepositorio;
import com.gestion.gastos.servicios.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    @Override
    public List<Categoria> obtenerCategorias(Usuario usuario) {
        return categoriaRepositorio.findAllByUsuario(usuario);
    }

    @Override
    public Categoria obtenerCategoria(long id) {
        return categoriaRepositorio.findById(id).get();
    }

    @Override
    public void eliminarCategoria(long id) {
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(id);
        categoriaRepositorio.delete(categoria);
    }

}
