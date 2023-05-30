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

    @Column(nullable = true)
    private double meta;
    //Tiempo en meses
    @Column(nullable = true)
    private int tiempoMeses;
    @Column(nullable = true)
    private double ahorroMensual;
    @Column(nullable = true)
    private String nombreObjetivo;

    @Column(name = "fecha_creacion", nullable = true)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion", nullable = true)
    private Date fechaModificacion;
    @Column(name = "usuario_creacion", nullable = true)
    private String usuarioCreacion;
    @Column(name = "usuario_modificacion", nullable = true)
    private String usuarioModificacion;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
}
