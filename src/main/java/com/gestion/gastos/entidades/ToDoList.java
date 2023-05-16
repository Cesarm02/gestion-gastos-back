package com.gestion.gastos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todolist")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoListId;

    private String titulo;
    private String categoria;
    private String cantidad;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

}
