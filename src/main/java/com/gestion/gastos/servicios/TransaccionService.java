package com.gestion.gastos.servicios;

import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.entidades.Transaccion;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransaccionService {

    Transaccion agregarTransaccion(Transaccion transaccion);
    Transaccion actualizarTransaccion(Transaccion transaccion);
    List<Transaccion> obtenerTransacciones();
    Transaccion obtenerTransaccion(Long id);
    void eliminarTransaccion(Long id);

    List<Transaccion> obtenerTransaccionPorCuenta(Cuenta cuenta);
    List<Transaccion> obtenerTransaccionPorCategoriaYCuenta(Cuenta cuentaId, Categoria categoriaId);
    List<Transaccion> obtenerTransaccionPorCategoria(Categoria categoriaId);
    Transaccion obtenerPorId(long id);

}
