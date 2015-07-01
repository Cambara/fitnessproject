package br.com.fitnessproject.model.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="historical_training")
public class HistoricalTraining {
	@Id@GeneratedValue
	private Long id;
	@Column(name="date")
	private Timestamp date;	
	@ManyToOne()
	@JoinColumn(name="trainer_card_id")
	private TrainerCard trainerCard;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public TrainerCard getTrainerCard() {
		return trainerCard;
	}
	public void setTrainerCard(TrainerCard trainerCard) {
		this.trainerCard = trainerCard;
	}
	
	
	
}

