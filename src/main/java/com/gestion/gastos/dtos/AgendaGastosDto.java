package com.gestion.gastos.dtos;

import com.gestion.gastos.entidades.Enum.Mes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendaGastosDto {

    private long id;
    private String titulo;
    private Date fecha;
    private double valorReal = 0;
    private double valorEsperado = 0;
    private String estado = "true";
    private Mes mes;
    private String descripcion;
}
