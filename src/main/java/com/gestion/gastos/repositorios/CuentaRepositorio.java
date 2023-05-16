package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Long> {
}
