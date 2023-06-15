package com.gestion.gastos.servicios.Impl;

import com.gestion.gastos.entidades.Categoria;
import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.entidades.Transaccion;
import com.gestion.gastos.repositorios.TransaccionRepositorio;
import com.gestion.gastos.servicios.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private TransaccionRepositorio transaccionRepositorio;

    @Override
    public Transaccion agregarTransaccion(Transaccion transaccion) {
        return transaccionRepositorio.save(transaccion);
    }

    @Override
    public Transaccion actualizarTransaccion(Transaccion transaccion) {
        return transaccionRepositorio.save(transaccion);
    }

    @Override
    public List<Transaccion> obtenerTransacciones() {
        return new ArrayList<>(transaccionRepositorio.findAll());
    }

    @Override
    public Transaccion obtenerTransaccion(Long id) {
        return transaccionRepositorio.findById(id).get();
    }

    @Override
    public void eliminarTransaccion(Long id) {
        Transaccion transaccion = new Transaccion();
        transaccion.setTransaccionId(id);
        transaccionRepositorio.delete(transaccion);
    }

    @Override
    public List<Transaccion> obtenerTransaccionPorCuenta(Cuenta cuenta) {
        return transaccionRepositorio.findAllByCuenta( cuenta);
    }

    @Override
    public List<Transaccion> obtenerTransaccionPorCategoriaYCuenta(Cuenta cuentaId, Categoria categoriaId) {
        return transaccionRepositorio.findByAllCuentaAndCategoria(categoriaId, cuentaId);

    }

    @Override
    public List<Transaccion> obtenerTransaccionPorCategoria(Categoria categoriaId) {
        return transaccionRepositorio.findAllByCategoria(categoriaId);
    }

    @Override
    public Transaccion obtenerPorId(long id) {
        return  transaccionRepositorio.findById(id).get();
    }

}
