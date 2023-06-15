package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditoriaRepositorio extends JpaRepository<Auditoria, Long> {
    List<Auditoria> findByUsuarioCreacion(String usuarioCreacion);

    List<Auditoria> findByUsuarioCreacionAndError(String usuarioCreacion, boolean error);

}
