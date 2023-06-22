package com.gestion.gastos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class RequestCreateUser{

	@JsonProperty("password")
	private String password;

	@JsonProperty("apellido")
	private String apellido;

	@JsonProperty("telefono")
	private Integer telefono;

	@JsonProperty("nombre")
	private String nombre;

	@JsonProperty("edad")
	private Integer edad;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;

	@JsonProperty("perfil")
	private String perfil;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setApellido(String apellido){
		this.apellido = apellido;
	}

	public String getApellido(){
		return apellido;
	}

	public void setTelefono(Integer telefono){
		this.telefono = telefono;
	}

	public Integer getTelefono(){
		return telefono;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}

	public void setEdad(Integer edad){
		this.edad = edad;
	}

	public Integer getEdad(){
		return edad;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setPerfil(String perfil){
		this.perfil = perfil;
	}

	public String getPerfil(){
		return perfil;
	}

	@Override
 	public String toString(){
		return 
			"RequestCreateUser{" + 
			"password = '" + password + '\'' + 
			",apellido = '" + apellido + '\'' + 
			",telefono = '" + telefono + '\'' + 
			",nombre = '" + nombre + '\'' + 
			",edad = '" + edad + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			",perfil = '" + perfil + '\'' + 
			"}";
		}
}