package com.gestion.gastos.controladores;

import com.gestion.gastos.dtos.HistoricoDto;
import com.gestion.gastos.entidades.HistoricoSimulacion;
import com.gestion.gastos.servicios.HistoricoSimulacionService;
import com.gestion.gastos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/simulacion")
@CrossOrigin("*")
public class SimuladorController {

    @Autowired
    private HistoricoSimulacionService historicoSimulacionService;
    @Autowired
    private Utilidades utilidades;

    @PostMapping("/")
    public ResponseEntity<?> planAhorro(@RequestBody HistoricoDto  historicoDto){
        double resultadoDouble = 0;
        String resultado = "";
        double resultadiInt = 0;
        if(historicoDto.getMeses()>0){
            resultadoDouble = Math.floor(historicoSimulacionService.calcularAhorroMensual(historicoDto.getMeta(), historicoDto.getMeses(), historicoDto.getObjetivo()));
            resultado = String.valueOf(resultadoDouble);
        }else{
            resultadiInt = historicoSimulacionService.calcularTiempo(historicoDto.getMeta(), historicoDto.getAhorro(), historicoDto.getObjetivo());
            resultado = String.valueOf(resultadiInt);
        }
        resultado = resultado.split("\\.")[0];
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/")
    public ResponseEntity<?> historico(){
        List<HistoricoSimulacion> historicoSimulacions= new ArrayList<>();
        try{
            historicoSimulacions = historicoSimulacionService.historico();
        }catch (Exception e){
            utilidades.agregarAuditoria("historico", e.getMessage(), true);
            e.printStackTrace();
        }
        return ResponseEntity.ok(historicoSimulacions);
    }

}
