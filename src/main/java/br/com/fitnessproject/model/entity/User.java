package br.com.fitnessproject.model.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.fitnessproject.model.enums.GenderUser;

@Entity
@Table(name="user")
public class User {
	@Id@GeneratedValue
	private Long id;
	@OneToOne
	private Login login;
	@Column(name="name")
	private String name;
	@Column
	private GenderUser gender;
	@Column
	private Date birthday;
	@OneToMany(mappedBy="user", targetEntity = Card.class, fetch = FetchType.LAZY)
	private List<Card> cards = new ArrayList<Card>();
	
	//gets e sets
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GenderUser getGender() {
		return gender;
	}
	public void setGender(GenderUser gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	

	
	
}
