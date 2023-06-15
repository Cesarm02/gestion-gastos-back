package com.gestion.gastos.excepciones;

public class UsuarioNotFoundException extends Exception{

    public UsuarioNotFoundException(){
        super("El usuario no existe en bd");
    }

    public  UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }

}
