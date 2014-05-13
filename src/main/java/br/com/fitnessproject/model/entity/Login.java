package br.com.fitnessproject.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.fitnessproject.model.enums.StatusLogin;
import br.com.fitnessproject.model.enums.TypeLogin;

@Entity
@Table(name="login")
public class Login {
	@Id@GeneratedValue
	private Long id;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private StatusLogin status;
	@Column
	private TypeLogin type;
	@OneToOne
	private Photo photo;
	
	// gets e sets
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StatusLogin getStatus() {
		return status;
	}
	public void setStatus(StatusLogin status) {
		this.status = status;
	}
	public TypeLogin getType() {
		return type;
	}
	public void setType(TypeLogin type) {
		this.type = type;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	
	
}
