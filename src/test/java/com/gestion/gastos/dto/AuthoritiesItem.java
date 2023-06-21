package com.gestion.gastos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthoritiesItem{

	@JsonProperty("authority")
	private String authority;

	public void setAuthority(String authority){
		this.authority = authority;
	}

	public String getAuthority(){
		return authority;
	}

	@Override
 	public String toString(){
		return 
			"AuthoritiesItem{" + 
			"authority = '" + authority + '\'' + 
			"}";
		}
}