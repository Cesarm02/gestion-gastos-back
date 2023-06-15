package com.gestion.gastos.controladores;

import com.gestion.gastos.dtos.AgendaGastosDto;
import com.gestion.gastos.entidades.AgendaGastos;
import com.gestion.gastos.servicios.AgendaGastosService;
import com.gestion.gastos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/agenda")
public class GastosController {

    @Autowired
    private AgendaGastosService agendaGastosService;
    @Autowired
    private Utilidades utilidades;

    @GetMapping("/")
    ResponseEntity<?> obtenerAgenda(){
        List<AgendaGastos> agendaGastos = new ArrayList<>();
        try{
            agendaGastos = agendaGastosService.obtenerAgendaGastos();
        }catch (Exception e){
            utilidades.agregarAuditoria("obtenerAgenda", "Error retornando la agenda", true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(agendaGastos);
    }

    @GetMapping("/{agendaId}")
    ResponseEntity<?> obtenerAgendaPorId(@PathVariable("agendaId") long agendaId){
        AgendaGastos agendaGastos = new AgendaGastos();
        try{
            agendaGastos = agendaGastosService.obtenerAgendaGastoPorId(agendaId);
        }catch (Exception e ){
            utilidades.agregarAuditoria("obtenerAgendaPorId", "Error retornando la agenda por id", true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(agendaGastos);
    }

    @PostMapping("/")
    ResponseEntity<?> agregarAgenda(@RequestBody AgendaGastosDto agendaGastosDto){
        AgendaGastos agendaGastos = new AgendaGastos();
        try{
            agendaGastos = agendaGastosService.agregarAgendaGasto(agendaGastosDto);
        }catch (Exception e){
            utilidades.agregarAuditoria("agregarAgenda", "Error agregando agenda", true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(agendaGastos);
    }

    @PutMapping("/")
    ResponseEntity<?> actualizarAgenda(@RequestBody AgendaGastosDto agendaGastosDto){
        AgendaGastos agendaGastos = new AgendaGastos();
        try{
            agendaGastos = agendaGastosService.editarAgendaGasto(agendaGastosDto);
        }catch (Exception e){
            utilidades.agregarAuditoria("actualizarAgenda", "Error actualizando agenda", true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(agendaGastos);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> eliminarAgenda(@PathVariable("id") int agendaId){
        String mensaje = "No se pudo eliminar";
        try{
            mensaje = agendaGastosService.eliinarAgendaGastos(agendaId);
        }catch (Exception e ){
            utilidades.agregarAuditoria("eliminarAgenda", "Error eliminando agenda", true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(mensaje);
    }

}
