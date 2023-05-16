package com.gestion.gastos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historicosimulacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoSimulacion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historicoSimulacionId;

    private double meta;
    //Tiempo en meses
    private int tiempo;
    private double ahorroMensual;
    private String nombreObjetivo;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
}
