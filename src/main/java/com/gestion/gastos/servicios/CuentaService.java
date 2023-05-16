package com.gestion.gastos.servicios;

import com.gestion.gastos.entidades.Cuenta;

import java.util.List;

public interface CuentaService {

    Cuenta agregarCuenta(Cuenta cuenta);
    Cuenta actualizarCuenta(Cuenta cuenta);
    List<Cuenta> obtenerCuentas();
    Cuenta obtenerCuenta(long id);
    void eliminarCuenta(long id);
}
