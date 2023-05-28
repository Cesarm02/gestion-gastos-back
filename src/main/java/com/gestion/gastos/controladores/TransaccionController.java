package com.gestion.gastos.controladores;

import com.gestion.gastos.dtos.TransaccionDto;
import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.entidades.Transaccion;
import com.gestion.gastos.entidades.Auditoria;
import com.gestion.gastos.servicios.*;
import com.gestion.gastos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transaccion")
@CrossOrigin("*")
public class TransaccionController {

    @Autowired
    private Utilidades utilidades;
    @Autowired
    private TransaccionService transaccionService;
    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/{cuentaId}")
    public ResponseEntity<?> obtenerTransacciones(@PathVariable("cuentaId") int cuentaId){
        List<Transaccion> transaccions = new ArrayList<>();
        try{
            Cuenta cuenta = cuentaService.obtenerCuenta(cuentaId);
            if(cuenta == null){
                utilidades.agregarAuditoria("obtenerTransaccionesPorCuenta", "La cuenta no existe", false);
                return ResponseEntity.ok("La cuenta no existe");
            }
            transaccions = transaccionService.obtenerTransaccionPorCuenta(cuenta);
            if(transaccions.isEmpty()){
                utilidades.agregarAuditoria("obtenerTransaccionesPorCuenta", "La cuenta no tiene transacciones", false);
                return ResponseEntity.ok("La cuenta no tiene transacciones");
            }

        }catch (Exception e){
            utilidades.agregarAuditoria("obtenerTransaccionesPorCuenta", e.getMessage(), true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(transaccions);
    }

    @PostMapping("/")
    public ResponseEntity<?> agregarTransaccion(@RequestBody TransaccionDto transaccionDto){
        Transaccion transaccion = new Transaccion();
        try{
            transaccion.setFecha(new Date());
            transaccion.setUsuarioCreacion(utilidades.obtenerUsuario());
            transaccion.setFechaCreacion(new Date());
            transaccion.setDescripcion(transaccionDto.getDescripcion());
            transaccion.setValor(transaccionDto.getValor());
            Cuenta cuenta = cuentaService.obtenerCuenta(Long.parseLong(transaccionDto.getCuenta()));
            cuenta.setFechaModificacion(new Date());
            cuenta.setUsuario(usuarioServicio.obtenerUsuario(utilidades.obtenerUsuario()));
            cuenta.setTotalCuenta(cuenta.getTotalCuenta() + transaccion.getValor());
            cuentaService.actualizarCuenta(cuenta);
            transaccion.setCuenta(cuenta);
            transaccion.setCategoria(categoriaService.obtenerCategoria(Long.parseLong(transaccionDto.getCategoria())));
            transaccion = transaccionService.actualizarTransaccion(transaccion);
        }catch (Exception e){
            utilidades.agregarAuditoria("agregarTransaccion", e.getMessage(), true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(transaccion);
    }

    @PutMapping("/")
    public ResponseEntity<?> editarTransaccion(@RequestBody  TransaccionDto transaccionDto){
        Transaccion transaccionAntigua = new Transaccion();
        try{
            transaccionAntigua = transaccionService.obtenerTransaccion(transaccionDto.getId());

            Cuenta cuenta = cuentaService.obtenerCuenta(Long.parseLong(transaccionDto.getCuenta()));
            cuenta.setFechaModificacion(new Date());
            cuenta.setUsuario(usuarioServicio.obtenerUsuario(utilidades.obtenerUsuario()));

            cuenta.setTotalCuenta(cuenta.getTotalCuenta() - transaccionAntigua.getValor() + transaccionDto.getValor());
            cuentaService.actualizarCuenta(cuenta);

            transaccionAntigua.setFecha(transaccionDto.getFecha());
            transaccionAntigua.setDescripcion(transaccionDto.getDescripcion());
            transaccionAntigua.setValor(transaccionDto.getValor());

            transaccionAntigua.setCuenta(cuenta);
            transaccionAntigua.setCategoria(categoriaService.obtenerCategoria(Long.parseLong(transaccionDto.getCategoria())));
            transaccionAntigua = transaccionService.actualizarTransaccion(transaccionAntigua);
        }catch (Exception e){
            utilidades.agregarAuditoria("editarTransaccion", e.getMessage(), true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(transaccionAntigua);
    }

    //Obtener transaccion por categoria
    //Obtener transaccion por categoria y cuenta

}
