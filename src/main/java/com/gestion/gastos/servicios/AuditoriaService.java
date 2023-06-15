package com.gestion.gastos.servicios;
import com.gestion.gastos.entidades.Auditoria;

import java.util.List;

public interface AuditoriaService {

    public void agregarAuditoria(Auditoria auditoria);
    public List<Auditoria> listAuditoria();
    public List<Auditoria> listAuditoriaPorUsuario(String username);
    public List<Auditoria> listAuditoriaPorUsuarioError(String username);
}
