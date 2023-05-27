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
    public List<Transaccion> obtenerTransaccionPorCuenta(long cuentaId) {
        return transaccionRepositorio.findByCuenta( cuentaId);
    }

    @Override
    public List<Transaccion> obtenerTransaccionPorCategoriaYCuenta(long cuentaId, long categoriaId) {
        return transaccionRepositorio.findByCuentaAndCategoria(cuentaId, categoriaId);

    }

    @Override
    public List<Transaccion> obtenerTransaccionPorCategoria(long categoriaId) {
        return transaccionRepositorio.findByCategoria(categoriaId);
    }

}
