package com.gestion.gastos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoDto {

    private double meta = 0;
    private double ahorro = 0;
    private int meses = 0;
    private String objetivo = "";

}
