package br.com.fitnessproject.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location {
	@Id@GeneratedValue
	private Long id;
	@Column
	private Double lat;
	@Column
	private Double lng;
	
	//gets e sets
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getlat() {
		return lat;
	}
	public void setlat(Double lat) {
		this.lat = lat;
	}
	public Double getlng() {
		return lng;
	}
	public void setlng(Double lng) {
		this.lng = lng;
	}
	
	
}
