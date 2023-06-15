package com.gestion.gastos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

    private String titulo;
    private String descripcion;
    private String usuario;
    private String id;
    private String estado;

}
