package com.gestion.gastos.controladores;

import com.gestion.gastos.entidades.Transaccion;
import com.gestion.gastos.entidades.Auditoria;
import com.gestion.gastos.servicios.AuditoriaService;
import com.gestion.gastos.servicios.TransaccionService;
import com.gestion.gastos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transaccion")
@CrossOrigin("*")
public class TransaccionController {

    @Autowired
    private Utilidades utilidades;
    @Autowired
    private TransaccionService transaccionService;

    @GetMapping("/{cuentaId}")
    public ResponseEntity<?> obtenerTransacciones(@PathVariable("cuentaId") long cuentaId){
        List<Transaccion> transaccions = new ArrayList<>();
        try{
            transaccions = transaccionService.obtenerTransaccionPorCuenta(cuentaId);
            if(transaccions.isEmpty()){
                utilidades.agregarAuditoria("obtenerTransaccionesPorCuenta", "La cuenta no tiene transaccioes", false);
                return ResponseEntity.ok("La cuenta no tiene transaccioes");
            }

        }catch (Exception e){
            utilidades.agregarAuditoria("obtenerTransaccionesPorCuenta", e.getMessage(), true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(transaccions);
    }

}
