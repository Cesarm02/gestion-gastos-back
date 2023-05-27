package com.gestion.gastos.servicios.Impl;

import com.gestion.gastos.entidades.Auditoria;
import com.gestion.gastos.repositorios.AuditoriaRepositorio;
import com.gestion.gastos.servicios.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

    @Autowired
    private AuditoriaRepositorio auditoriaRepositorio;

    @Override
    public void agregarAuditoria(Auditoria auditoria) {
        auditoriaRepositorio.save(auditoria);
    }

    @Override
    public List<Auditoria> listAuditoria() {
        return auditoriaRepositorio.findAll();
    }

    @Override
    public List<Auditoria> listAuditoriaPorUsuario(String username) {
        return auditoriaRepositorio.findByUsuarioCreacion(username);
    }
}
