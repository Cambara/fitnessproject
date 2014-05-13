package br.com.fitnessproject.model.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="card")
public class Card {
	
	@Id@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column(name = "date_begin")
	private Date dateBegin;
	@Column(name = "date_end")
	private Date dateEnd;
	@OneToMany(targetEntity = Exercise.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Exercise> exercise;
	
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
	public Date getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public List<Exercise> getExercise() {
		return exercise;
	}
	public void setExercise(List<Exercise> exercise) {
		this.exercise = exercise;
	}
	
	
}
