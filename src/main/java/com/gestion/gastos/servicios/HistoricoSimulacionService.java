package com.gestion.gastos.servicios;

import com.gestion.gastos.entidades.HistoricoSimulacion;

public interface HistoricoSimulacionService {

    double calcularAhorroMensual(double meta, int tiempo, String objetivo);
    int calcularTiempo(double meta, double ahorroMensual, String objetivo);


}
