package com.gestion.gastos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionDto {

    private long id;
    private String descripcion;
    private double valor;
    private String cuenta;
    private String categoria;
    private Date fecha;

}
