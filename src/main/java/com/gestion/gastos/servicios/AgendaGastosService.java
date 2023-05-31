package com.gestion.gastos.servicios;

import com.gestion.gastos.dtos.AgendaGastosDto;
import com.gestion.gastos.entidades.AgendaGastos;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AgendaGastosService {

    List<AgendaGastos> obtenerAgendaGastos();
    AgendaGastos obtenerAgendaGastoPorId(long agendaGastoId);
    AgendaGastos agregarAgendaGasto(AgendaGastosDto agendaGastosDto);
    AgendaGastos editarAgendaGasto(AgendaGastosDto agendaGastosDto);
    String eliinarAgendaGastos(long agendaGastoId);
}
