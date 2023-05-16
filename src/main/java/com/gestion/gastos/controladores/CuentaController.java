package com.gestion.gastos.controladores;

import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.servicios.CuentaService;
import com.gestion.gastos.util.Utilidades;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cuenta")
@CrossOrigin("*")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private Utilidades utilidades;

    @GetMapping("/")
    public ResponseEntity<?> obtenerCuentas(){
        List<Cuenta> cuentas = new ArrayList<>();
        try{
            cuentas = cuentaService.obtenerCuentas();
            if(cuentas.isEmpty()){
                return ResponseEntity.ok("No hay datos");
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCuenta(@PathVariable("id") long id){
        Cuenta cuenta = new Cuenta();
        try{
            cuenta = cuentaService.obtenerCuenta(id);
            if(cuenta == null)
                return ResponseEntity.ok("Cuenta no encontrada");
        }catch (Exception e ){
            e.printStackTrace();
        }
        return ResponseEntity.ok(cuenta);
    }

    @PostMapping("/")
    public Cuenta guardarCuenta(@RequestBody Cuenta cuenta){
        Cuenta cuentaGuardada = new Cuenta();
        try{
            cuenta.setUsuarioCreacion(utilidades.obtenerUsuario());
            cuenta.setFechaCreacion(new Date());
            cuentaGuardada = cuentaService.agregarCuenta(cuenta);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return cuentaGuardada;
    }

    @PutMapping("/")
    public Cuenta actualiarCuenta(@RequestBody Cuenta cuenta){
        try{
            cuenta.setUsuarioModificacion(utilidades.obtenerUsuario());
            cuenta.setFechaModificacion(new Date());

        }catch (Exception e){
            e.printStackTrace();
        }
        return cuentaService.actualizarCuenta(cuenta);
    }
    @DeleteMapping("/{id}")
    public void eliminarCuenta(@PathVariable("id") long id){
        try{
            cuentaService.eliminarCuenta(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
