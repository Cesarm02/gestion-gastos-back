package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriaRepositorio extends JpaRepository<Auditoria, Long> {
}
