package com.gestion.gastos.controladores;

import com.gestion.gastos.dtos.HistoricoDto;
import com.gestion.gastos.servicios.HistoricoSimulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;

@RestController
@RequestMapping("/simulacion")
@CrossOrigin("*")
public class SimuladorController {

    @Autowired
    private HistoricoSimulacionService historicoSimulacionService;

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


}
