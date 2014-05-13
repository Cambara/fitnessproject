package br.com.fitnessproject.model.enums;

public enum GenderUser {
	 MALE("Masculino"), FEMALE("Feminino");

	private String desc;

	private GenderUser(String desc) {
		this.desc = desc;
	}


	public String getDescription() {
		return desc;
	}
}
