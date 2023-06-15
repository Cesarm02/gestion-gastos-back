package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Long> {

    List<Cuenta> findAllByUsuario(Usuario usuario);

}
