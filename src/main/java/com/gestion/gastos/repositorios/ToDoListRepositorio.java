package com.gestion.gastos.repositorios;

import com.gestion.gastos.entidades.Cuenta;
import com.gestion.gastos.entidades.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepositorio extends JpaRepository<ToDoList, Long> {
}
