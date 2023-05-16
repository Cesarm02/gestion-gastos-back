package com.gestion.gastos.entidades;

import com.gestion.gastos.entidades.Enum.Mes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaccion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaccionId;

    private Date fecha;
    private String descripcion;
    private double valor;
    private Mes mes;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cuenta cuenta;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
}
