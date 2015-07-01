package br.com.fitnessproject.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="exercise")
public class Exercise {
	@Id@GeneratedValue
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name ="n_repeat")
	private String nRepeat;
	@Column
	private String weight;
	@Column
	private Integer serie;
	@ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="trainer_id")
	private TrainerCard trainerCard;
	
	//gets e sets
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getnRepeat() {
		return nRepeat;
	}
	public void setnRepeat(String nRepeat) {
		this.nRepeat = nRepeat;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Integer getSerie() {
		return serie;
	}
	public void setSerie(Integer serie) {
		this.serie = serie;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TrainerCard getTrainerCard() {
		return trainerCard;
	}
	public void setTrainerCard(TrainerCard trainerCard) {
		this.trainerCard = trainerCard;
	}
	
	
	
	
}
