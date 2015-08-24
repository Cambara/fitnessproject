package br.com.fitnessproject.model.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="trainer_card")
public class TrainerCard {
	@Id@GeneratedValue
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String desc;
	@Column(name="last_trainer")
	private Timestamp lastTrainer;
	@Column(name="rest_begin")
	private String restBegin;
	@Column(name="rest_end")
	private String restEnd;
	@OneToMany(mappedBy="trainerCard",targetEntity = Exercise.class, fetch = FetchType.EAGER, cascade ={ CascadeType.ALL}, orphanRemoval = true)
	private List<Exercise> exercises = new ArrayList<Exercise>();
	@OneToMany(mappedBy="trainerCard",targetEntity = HistoricalTraining.class, fetch = FetchType.LAZY, cascade ={ CascadeType.REMOVE}, orphanRemoval = true)
	private List<HistoricalTraining> historical = new ArrayList<HistoricalTraining>();
	@ManyToOne()
	@JoinColumn(name="card_id")
	private Card card;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Timestamp getLastTrainer() {
		return lastTrainer;
	}

	public void setLastTrainer(Timestamp lastTrainer) {
		this.lastTrainer = lastTrainer;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	public Card getCard() {
		return this.card;
	}

	public void setCard(Card card) {
		this.card= card;
	}

	public List<HistoricalTraining> getHistorical() {
		return historical;
	}

	public void setHistorical(List<HistoricalTraining> historical) {
		this.historical = historical;
	}

	public String getRestBegin() {
		return restBegin;
	}

	public void setRestBegin(String restBegin) {
		this.restBegin = restBegin;
	}

	public String getRestEnd() {
		return restEnd;
	}

	public void setRestEnd(String restEnd) {
		this.restEnd = restEnd;
	}	
	
	
}
