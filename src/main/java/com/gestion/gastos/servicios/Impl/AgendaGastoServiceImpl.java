package com.gestion.gastos.servicios.Impl;

import com.gestion.gastos.dtos.AgendaGastosDto;
import com.gestion.gastos.entidades.AgendaGastos;
import com.gestion.gastos.repositorios.AgendaGastosRepositorio;
import com.gestion.gastos.servicios.AgendaGastosService;
import com.gestion.gastos.servicios.UsuarioServicio;
import com.gestion.gastos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AgendaGastoServiceImpl implements AgendaGastosService {

    @Autowired
    private AgendaGastosRepositorio  agendaGastosRepositorio;
    @Autowired
    private Utilidades utilidades;
    @Autowired
    private UsuarioServicio usuarioServicio;


    @Override
    public List<AgendaGastos> obtenerAgendaGastos() {
        List<AgendaGastos> agendaGastos = agendaGastosRepositorio.findAllByUsuario(usuarioServicio.obtenerUsuario(utilidades.obtenerUsuario()));
        return agendaGastos;
    }

    @Override
    public AgendaGastos obtenerAgendaGastoPorId(long agendaGastoId) {
        AgendaGastos agendaGastos = agendaGastosRepositorio.findById(agendaGastoId).get();
        return agendaGastos;
    }

    @Override
    public AgendaGastos agregarAgendaGasto(AgendaGastosDto agendaGastosDto) {
        AgendaGastos agendaGastos = new AgendaGastos();
        agendaGastos.setValorReal(agendaGastosDto.getValorReal());
        agendaGastos.setValorEsperado(agendaGastosDto.getValorEsperado());
        if(agendaGastos.getValorEsperado() == 0){
            agendaGastos.setValorEsperado(agendaGastos.getValorReal());
        }
        agendaGastos.setDiferencia(agendaGastos.getValorEsperado() - agendaGastos.getValorReal() );
        agendaGastos.setFechaCreacion(new Date());
        agendaGastos.setUsuario(usuarioServicio.obtenerUsuario(utilidades.obtenerUsuario()));
        agendaGastos.setFecha(agendaGastosDto.getFecha());
        agendaGastos.setDescripcion(agendaGastosDto.getDescripcion());
        agendaGastos.setMes(agendaGastosDto.getMes());
        agendaGastos.setTitulo(agendaGastosDto.getTitulo());
        agendaGastos.setUsuarioCreacion(utilidades.obtenerUsuario());
        AgendaGastos agendaGastos1 = agendaGastosRepositorio.save(agendaGastos);
        return agendaGastos1;
    }

    @Override
    public AgendaGastos editarAgendaGasto(AgendaGastosDto agendaGastosDto) {
        AgendaGastos agendaGastosAntiguo = agendaGastosRepositorio.findById(agendaGastosDto.getId()).get();
        agendaGastosAntiguo.setDescripcion(agendaGastosDto.getDescripcion());
        agendaGastosAntiguo.setFecha(agendaGastosDto.getFecha());
        agendaGastosAntiguo.setValorEsperado(agendaGastosDto.getValorEsperado());
        agendaGastosAntiguo.setValorReal(agendaGastosDto.getValorReal());
        agendaGastosAntiguo.setTitulo(agendaGastosDto.getTitulo());
        agendaGastosAntiguo.setDescripcion(agendaGastosDto.getDescripcion());
        agendaGastosAntiguo.setEstado(Boolean.parseBoolean(agendaGastosDto.getEstado()));
        if(agendaGastosDto.getValorEsperado() == 0){
            agendaGastosAntiguo.setValorEsperado(agendaGastosDto.getValorReal());
        }
        agendaGastosAntiguo.setDiferencia(agendaGastosAntiguo.getValorEsperado() - agendaGastosAntiguo.getValorReal());
        agendaGastosAntiguo.setMes(agendaGastosDto.getMes());
        agendaGastosAntiguo.setFechaModificacion(new Date());
        AgendaGastos agendaGastos = agendaGastosRepositorio.save(agendaGastosAntiguo);
        return agendaGastos;
    }

    @Override
    public String eliinarAgendaGastos(long agendaGastoId) {
        String mensaje = "";
        AgendaGastos agendaGastos = agendaGastosRepositorio.findById(agendaGastoId).get();
        agendaGastosRepositorio.delete(agendaGastos);
        mensaje = "Eliminado correctamente";
        return mensaje;
    }
}
