package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.entidades.HistoricoSimulacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoSimulacionRepositorio extends JpaRepository<HistoricoSimulacion, Long> {
}
