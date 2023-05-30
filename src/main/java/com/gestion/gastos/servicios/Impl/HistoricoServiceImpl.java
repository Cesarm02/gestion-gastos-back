package com.gestion.gastos.servicios.Impl;

import com.gestion.gastos.entidades.HistoricoSimulacion;
import com.gestion.gastos.repositorios.HistoricoSimulacionRepositorio;
import com.gestion.gastos.servicios.HistoricoSimulacionService;
import com.gestion.gastos.servicios.UsuarioServicio;
import com.gestion.gastos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HistoricoServiceImpl implements HistoricoSimulacionService {

    @Autowired
    private HistoricoSimulacionRepositorio historicoSimulacionRepositorio;

    @Autowired
    private Utilidades utilidades;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Override
        public double calcularAhorroMensual(double meta, int tiempo, String objetivo) {
        double resultado = 0;
        try{
            HistoricoSimulacion historicoSimulacion = new HistoricoSimulacion();
            historicoSimulacion.setMeta(meta);
            historicoSimulacion.setTiempoMeses(tiempo);
            resultado =  meta / tiempo;
            historicoSimulacion.setAhorroMensual(resultado);
            historicoSimulacion.setFechaCreacion(new Date());
            historicoSimulacion.setNombreObjetivo(objetivo);
            historicoSimulacion.setUsuario(usuarioServicio.obtenerUsuario(utilidades.obtenerUsuario()));
            historicoSimulacionRepositorio.save(historicoSimulacion);
        }catch (Exception e){
            utilidades.agregarAuditoria("calcularAhorroMensual", e.getMessage(), true);
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public int calcularTiempo(double meta, double ahorroMensual, String objetivo) {

        HistoricoSimulacion historicoSimulacion = new HistoricoSimulacion();
        historicoSimulacion.setMeta(meta);
        historicoSimulacion.setAhorroMensual(ahorroMensual);
        int resultado = Double.valueOf(meta / ahorroMensual).intValue();
        historicoSimulacion.setTiempoMeses(resultado);
        historicoSimulacion.setFechaCreacion(new Date());
        historicoSimulacion.setNombreObjetivo(objetivo);
        historicoSimulacion.setUsuario(usuarioServicio.obtenerUsuario(utilidades.obtenerUsuario()));
        historicoSimulacionRepositorio.save(historicoSimulacion);
        return resultado;
    }


}
