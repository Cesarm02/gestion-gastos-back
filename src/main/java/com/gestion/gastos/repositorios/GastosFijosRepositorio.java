package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Auditoria;
import com.gestion.gastos.entidades.GastosFijos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastosFijosRepositorio extends JpaRepository<GastosFijos, Long> {
}
