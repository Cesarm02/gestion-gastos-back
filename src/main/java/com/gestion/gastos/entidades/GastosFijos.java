package com.gestion.gastos.entidades;

import com.gestion.gastos.entidades.Enum.Mes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gastosfijos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GastosFijos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gastosFijosId;

    private String titulo;
    private Date fecha;
    private double valorEsperado;
    private double valorReal;
    private boolean estado = true;
    private Mes mes;
    private String descripcion;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

}
