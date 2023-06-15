package com.gestion.gastos.servicios;

import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.entidades.Usuario;

import java.util.List;

public interface CuentaService {

    Cuenta agregarCuenta(Cuenta cuenta);
    Cuenta actualizarCuenta(Cuenta cuenta);
    List<Cuenta> obtenerCuentas(Usuario usuario);
    Cuenta obtenerCuenta(long id);
    void eliminarCuenta(long id);

}
