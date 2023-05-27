package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.entidades.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaccionRepositorio extends JpaRepository<Transaccion, Long> {

    List<Transaccion> findByCategoria(long categoriaId);
    List<Transaccion> findByCuentaAndCategoria(long cuentaId, long categoriaId);
    List<Transaccion> findByCuenta(long cuentaId);

}
