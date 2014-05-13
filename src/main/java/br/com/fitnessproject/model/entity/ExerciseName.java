package br.com.fitnessproject.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exercise_name")
public class ExerciseName {
	
	@Id@GeneratedValue@Column(name ="id_exercise_name")
	private Long id;
	@Column
	private String name;
	
	//gets e sets
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
}
