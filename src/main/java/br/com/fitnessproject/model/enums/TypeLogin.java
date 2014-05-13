package br.com.fitnessproject.model.enums;

public enum TypeLogin {
	
	ADMIN("Administrador"), USER("Usuário"), GYM("academia");
	private String desc;
	private TypeLogin(String desc){
		this.desc = desc;
	}
	public String getDesc(){
		return this.desc;
	}
	

}
