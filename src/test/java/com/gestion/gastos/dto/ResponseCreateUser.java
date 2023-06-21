package com.gestion.gastos.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCreateUser{

	@JsonProperty("credentialsNonExpired")
	private Boolean credentialsNonExpired;

	@JsonProperty("nombre")
	private String nombre;

	@JsonProperty("edad")
	private Integer edad;

	@JsonProperty("enabled")
	private Boolean enabled;

	@JsonProperty("authorities")
	private List<AuthoritiesItem> authorities;

	@JsonProperty("perfil")
	private String perfil;

	@JsonProperty("password")
	private String password;

	@JsonProperty("apellido")
	private String apellido;

	@JsonProperty("accountNonExpired")
	private Boolean accountNonExpired;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("telefono")
	private String telefono;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;

	@JsonProperty("accountNonLocked")
	private Boolean accountNonLocked;

	public void setCredentialsNonExpired(Boolean credentialsNonExpired){
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Boolean isCredentialsNonExpired(){
		return credentialsNonExpired;
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

	public void setEnabled(Boolean enabled){
		this.enabled = enabled;
	}

	public Boolean isEnabled(){
		return enabled;
	}

	public void setAuthorities(List<AuthoritiesItem> authorities){
		this.authorities = authorities;
	}

	public List<AuthoritiesItem> getAuthorities(){
		return authorities;
	}

	public void setPerfil(String perfil){
		this.perfil = perfil;
	}

	public String getPerfil(){
		return perfil;
	}

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

	public void setAccountNonExpired(Boolean accountNonExpired){
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean isAccountNonExpired(){
		return accountNonExpired;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setTelefono(String telefono){
		this.telefono = telefono;
	}

	public String getTelefono(){
		return telefono;
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

	public void setAccountNonLocked(Boolean accountNonLocked){
		this.accountNonLocked = accountNonLocked;
	}

	public Boolean isAccountNonLocked(){
		return accountNonLocked;
	}

	@Override
 	public String toString(){
		return 
			"ResponseCreateUser{" + 
			"credentialsNonExpired = '" + credentialsNonExpired + '\'' + 
			",nombre = '" + nombre + '\'' + 
			",edad = '" + edad + '\'' + 
			",enabled = '" + enabled + '\'' + 
			",authorities = '" + authorities + '\'' + 
			",perfil = '" + perfil + '\'' + 
			",password = '" + password + '\'' + 
			",apellido = '" + apellido + '\'' + 
			",accountNonExpired = '" + accountNonExpired + '\'' + 
			",id = '" + id + '\'' + 
			",telefono = '" + telefono + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			",accountNonLocked = '" + accountNonLocked + '\'' + 
			"}";
		}
}