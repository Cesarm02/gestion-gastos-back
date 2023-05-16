package com.gestion.gastos.servicios.Impl;

import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.repositorios.CuentaRepositorio;
import com.gestion.gastos.servicios.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepositorio cuentaRepositorio;

    @Override
    public Cuenta agregarCuenta(Cuenta cuenta) {
        return cuentaRepositorio.save(cuenta);
    }

    @Override
    public Cuenta actualizarCuenta(Cuenta cuenta) {
        return cuentaRepositorio.save(cuenta);
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        return cuentaRepositorio.findAll();
    }

    @Override
    public Cuenta obtenerCuenta(long id) {
        return cuentaRepositorio.findById(id).get();
    }

    @Override
    public void eliminarCuenta(long id) {
        Cuenta cuenta = new Cuenta();
        cuenta.setCuentaId(id);
        cuentaRepositorio.delete(cuenta);
    }
}
