package com.gestion.gastos.util;

import com.gestion.gastos.entidades.Auditoria;
import com.gestion.gastos.servicios.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Utilidades {

    @Autowired
    private AuditoriaService auditoriaService;

    public String obtenerUsuario(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public void agregarAuditoria(String accion, String descripcion, boolean error){
        Auditoria auditoria = new Auditoria();
        auditoria.setAccion(accion);
        auditoria.setDescripcionError(descripcion);
        auditoria.setError(error);
        auditoria.setFechaCreacion(new Date());
        auditoria.setUsuarioCreacion(obtenerUsuario());
        auditoriaService.agregarAuditoria(auditoria);
    }

}
