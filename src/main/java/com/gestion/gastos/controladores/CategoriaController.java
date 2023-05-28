package com.gestion.gastos.controladores;

import com.gestion.gastos.dtos.CategoriaDto;
import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.entidades.Usuario;
import com.gestion.gastos.servicios.CategoriaService;
import com.gestion.gastos.servicios.UsuarioServicio;
import com.gestion.gastos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/")
    public ResponseEntity<Categoria> guardarCategoria(@RequestBody CategoriaDto categoriaDto){
        Categoria categoria = new Categoria();
        categoria.setUsuario(usuarioServicio.obtenerUsuario(utilidades.obtenerUsuario()));
        categoria.setUsuarioCreacion(utilidades.obtenerUsuario());
        categoria.setFechaCreacion(new Date());
        categoria.setDescripcion(categoriaDto.getDescripcion());
        categoria.setTitulo(categoriaDto.getTitulo());
        Categoria categoriaGuardar = categoriaService.agregarCategoria(categoria);
        return ResponseEntity.ok(categoriaGuardar);
    }

    @GetMapping("/{categoriaId}")
    public Categoria listarCategoriaPorId(@PathVariable("categoriaId") long categoriaId){
        return categoriaService.obtenerCategoria(categoriaId);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCategoria(){
        Usuario usuario = usuarioServicio.obtenerUsuario(utilidades.obtenerUsuario());
        return ResponseEntity.ok(categoriaService.obtenerCategorias(usuario));
    }

    @PutMapping("/")
    public Categoria actualizarCategoria(@RequestBody CategoriaDto categoriaDto ){
        Categoria categoria = new Categoria();
        try{
            categoria = categoriaService.obtenerCategoria(Long.parseLong(categoriaDto.getId()));
            categoria.setFechaModificacion(new Date());
            categoria.setTitulo(categoriaDto.getTitulo());
            categoria.setDescripcion(categoriaDto.getDescripcion());
            categoria.setUsuarioModificacion(utilidades.obtenerUsuario());
            categoria.setEstado(Boolean.parseBoolean(categoriaDto.getEstado()));
        }catch (Exception e ){
            utilidades.agregarAuditoria("actualizarCategoria", e.getMessage(), true);
            e.printStackTrace();
        }
        return categoriaService.actualizarCategoria(categoria);
    }

    @DeleteMapping("/{categoriaId}")
    public void eliminarCategoria(@PathVariable("categoriaId") long id){
        categoriaService.eliminarCategoria(id);
    }

}
