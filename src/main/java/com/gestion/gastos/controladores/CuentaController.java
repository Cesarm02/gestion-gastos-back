package com.gestion.gastos.controladores;

import com.gestion.gastos.dtos.CuentaDTO;
import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.entidades.Usuario;
import com.gestion.gastos.servicios.CuentaService;
import com.gestion.gastos.servicios.UsuarioServicio;
import com.gestion.gastos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public ResponseEntity<?> obtenerCuentas(){
        List<Cuenta> cuentas = new ArrayList<>();
        Usuario usuario = usuarioServicio.obtenerUsuario(utilidades.obtenerUsuario());
        try{
            cuentas = cuentaService.obtenerCuentas(usuario);
            if(cuentas.isEmpty()){
                utilidades.agregarAuditoria("obtenerCuentas", "No existe la cuenta", false);

            }
        }catch (Exception e ){
            utilidades.agregarAuditoria("obtenerCuentas", e.getMessage(), true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCuenta(@PathVariable("id") long id){
        Cuenta cuenta = new Cuenta();
        try{
            cuenta = cuentaService.obtenerCuenta(id);
            if(cuenta == null){
                utilidades.agregarAuditoria("obtenerCuenta", "Cuenta no encontrada", false);
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return ResponseEntity.ok(cuenta);
    }

    @PostMapping("/")
    public Cuenta guardarCuenta(@RequestBody CuentaDTO cuentaDTO){
        Cuenta cuenta = new Cuenta();
        try{
            cuenta.setTipo(cuentaDTO.getTipo());
            cuenta.setTitulo(cuentaDTO.getTitulo());
            cuenta.setDescripcion(cuentaDTO.getDescripcion());
            cuenta.setUsuario(usuarioServicio.obtenerUsuario(utilidades.obtenerUsuario()));
            cuenta.setUsuarioCreacion(utilidades.obtenerUsuario());
            cuenta.setFechaCreacion(new Date());
            cuenta.setTotalCuenta(cuentaDTO.getTotal());
            cuenta = cuentaService.agregarCuenta(cuenta);
        }catch (Exception e ){
            utilidades.agregarAuditoria("guardarCuenta", e.getMessage(), true);
            e.printStackTrace();
        }
        return cuenta;
    }

    @PutMapping("/")
    public Cuenta actualiarCuenta(@RequestBody CuentaDTO cuentaDTO){
        Cuenta cuenta = new Cuenta();
        try{
            cuenta = cuentaService.obtenerCuenta(Long.parseLong(cuentaDTO.getId()));
            cuenta.setUsuarioModificacion(utilidades.obtenerUsuario());
            cuenta.setFechaModificacion(new Date());
            cuenta.setTitulo(cuentaDTO.getTitulo());
            cuenta.setDescripcion(cuentaDTO.getDescripcion());
            cuenta.setTitulo(cuentaDTO.getTitulo());
            cuenta.setTotalCuenta(cuentaDTO.getTotal());
            cuenta.setTipo(cuentaDTO.getTipo());
            cuenta.setEstado(Boolean.parseBoolean(cuentaDTO.getEstado()));
            cuenta = cuentaService.actualizarCuenta(cuenta);

        }catch (Exception e){
            utilidades.agregarAuditoria("actualiarCuenta", e.getMessage(), true);
            e.printStackTrace();
        }
        return cuenta;
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
