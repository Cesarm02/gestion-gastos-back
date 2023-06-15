package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.entidades.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransaccionRepositorio extends JpaRepository<Transaccion, Long> {

    List<Transaccion> findAllByCategoria(Categoria categoria);
    @Query(value = "SELECT t FROM Transaccion t WHERE t.categoria = :categoria and t.cuenta = :cuenta" )
    List<Transaccion> findByAllCuentaAndCategoria(@Param("categoria") Categoria categoria, @Param("cuenta")Cuenta cuenta);
    List<Transaccion> findAllByCuenta(Cuenta cuenta);

}
