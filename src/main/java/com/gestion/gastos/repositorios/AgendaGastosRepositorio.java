package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.AgendaGastos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaGastosRepositorio extends JpaRepository<AgendaGastos, Long> {
}
