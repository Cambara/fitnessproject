package br.com.fitnessproject.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name ="n_repeat")
	private Double nRepeat;
	@Column
	private Double weight;
	@ManyToOne
	@JoinColumn(name="id_exercise_name")
	private ExerciseName exerciseName;
	
	//gets e sets
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getnRepeat() {
		return nRepeat;
	}
	public void setnRepeat(Double nRepeat) {
		this.nRepeat = nRepeat;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public ExerciseName getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(ExerciseName exerciseName) {
		this.exerciseName = exerciseName;
	}
	
	
	
}
