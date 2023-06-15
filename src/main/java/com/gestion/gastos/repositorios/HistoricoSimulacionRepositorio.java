package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.HistoricoSimulacion;
import com.gestion.gastos.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoSimulacionRepositorio extends JpaRepository<HistoricoSimulacion, Long> {

    List<HistoricoSimulacion> findAllByUsuario(Usuario usuario);

}
