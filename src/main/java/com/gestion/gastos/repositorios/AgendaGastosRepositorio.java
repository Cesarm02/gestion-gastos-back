package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.AgendaGastos;
import com.gestion.gastos.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaGastosRepositorio extends JpaRepository<AgendaGastos, Long> {

    List<AgendaGastos> findAllByUsuario(Usuario  usuario);

}
