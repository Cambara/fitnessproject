package br.com.fitnessproject.model.enums;

public enum StatusLogin {
	ACTIVE("ativo"), DEACTIVATED("desativado"),BLOCKED("bloqueado"), WAIT("espera");
	
	private String desc;
	private StatusLogin(String desc){
		this.desc = desc;
	}
	public String getDesc(){
		return this.desc;
	}
}
