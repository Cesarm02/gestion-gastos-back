package com.gestion.gastos.controladores;

import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.servicios.CategoriaService;
import com.gestion.gastos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private Utilidades utilidades;

    @PostMapping("/")
    public ResponseEntity<Categoria> guardarCategoria(@RequestBody  Categoria categoria){
        categoria.setUsuarioCreacion(utilidades.obtenerUsuario());
        categoria.setFechaCreacion(new Date());
        Categoria categoriaGuardar = categoriaService.agregarCategoria(categoria);
        return ResponseEntity.ok(categoriaGuardar);
    }

    @GetMapping("/{categoriaId}")
    public Categoria listarCategoriaPorId(@PathVariable("categoriaId") long categoriaId){
        return categoriaService.obtenerCategoria(categoriaId);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCategoria(){
        return ResponseEntity.ok(categoriaService.obtenerCategorias());
    }

    @PutMapping("/")
    public Categoria actualizarCategoria(@RequestBody Categoria categoria){
        return categoriaService.actualizarCategoria(categoria);
    }

    @DeleteMapping("/{categoriaId}")
    public void eliminarCategoria(@PathVariable("categoriaId") long id){
        categoriaService.eliminarCategoria(id);
    }

}
