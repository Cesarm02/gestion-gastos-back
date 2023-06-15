package com.gestion.gastos.controladores;

import com.gestion.gastos.servicios.AuditoriaService;
import com.gestion.gastos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestion.gastos.entidades.Auditoria;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/auditoria")
public class AuditoriaController {

    @Autowired
    private Utilidades utilidades;

    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Auditoria> auditorias = auditoriaService.listAuditoria();
        return ResponseEntity.ok(auditorias);
    }

    @GetMapping("/{usuario}")
    public ResponseEntity<?> getAuditoriaUsuario(@PathVariable("usuario") String usuario){
        List<Auditoria> auditorias = new ArrayList<>();
        try{
            auditoriaService.listAuditoriaPorUsuario(usuario);
        }catch (Exception e ){
            utilidades.agregarAuditoria("getAuditoriaUsuario", "Error retornando auditoria", true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(auditorias);
    }

    @GetMapping("/")
    public ResponseEntity<?> getErroresUsuario(){
        List<Auditoria> auditorias = new ArrayList<>();
        try{
            auditorias = auditoriaService.listAuditoriaPorUsuarioError(utilidades.obtenerUsuario());
        }catch (Exception e ){
            utilidades.agregarAuditoria("getErroresUsuario", "Error retornando auditoria", true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(auditorias);
    }



}
