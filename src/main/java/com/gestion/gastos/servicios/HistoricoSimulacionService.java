package com.gestion.gastos.servicios;

import com.gestion.gastos.entidades.HistoricoSimulacion;

import java.util.List;

public interface HistoricoSimulacionService {

    double calcularAhorroMensual(double meta, int tiempo, String objetivo);
    int calcularTiempo(double meta, double ahorroMensual, String objetivo);

    List<HistoricoSimulacion> historico();

}
