package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.entidades.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaccionRepositorio extends JpaRepository<Transaccion, Long> {

    List<Transaccion> findByCategoria(long categoria);
    List<Transaccion> findByCuentaAndCategoria(long cuenta, long categoria);
    List<Transaccion> findAllByCuenta(Cuenta cuenta);

}
