package com.gestion.gastos.excepciones;

public class UsuarioFoundException extends Exception{
    public UsuarioFoundException(){
        super("El usuario con ese username ya existe en bd");
    }

    public  UsuarioFoundException(String mensaje){
        super(mensaje);
    }

}
