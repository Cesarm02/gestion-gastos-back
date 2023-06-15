package com.gestion.gastos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {

    private String usuario;
    private String id;
    private String titulo;
    private String descripcion;
    private String tipo;
    private double total;
    private String estado;
}
