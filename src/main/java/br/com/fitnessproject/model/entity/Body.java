package br.com.fitnessproject.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="body")
public class Body {
	@Id@GeneratedValue
	private Long id;
	@Column
	private Double heigth;
	@Column
	private Double weigth;
	@Column
	private Double bust;
	@Column
	private Double back;
	@Column
	private Double waist;
	@Column(name ="biceps_l")
	private Double bicepsL;
	@Column(name ="biceps_r")
	private Double bicepsR;
	@Column(name ="leg_l")
	private Double legL;
	@Column(name ="leg_r")
	private Double legR;
	@Column
	private Date date;
	@Column
	private Double hip;
	@Column
	private Double forearmL;
	@Column
	private Double forearmR;
	@Column
	private Double calfL;
	@Column
	private Double calfR;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	//gets e sets
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getHeigth() {
		return heigth;
	}
	public void setHeigth(Double heigth) {
		this.heigth = heigth;
	}
	public Double getWeigth() {
		return weigth;
	}
	public void setWeigth(Double weigth) {
		this.weigth = weigth;
	}
	public Double getBust() {
		return bust;
	}
	public void setBust(Double bust) {
		this.bust = bust;
	}
	public Double getBack() {
		return back;
	}
	public void setBack(Double back) {
		this.back = back;
	}
	public Double getWaist() {
		return waist;
	}
	public void setWaist(Double waist) {
		this.waist = waist;
	}
	public Double getBicepsL() {
		return bicepsL;
	}
	public void setBicepsL(Double bicepsL) {
		this.bicepsL = bicepsL;
	}
	public Double getBicepsR() {
		return bicepsR;
	}
	public void setBicepsR(Double bicepsR) {
		this.bicepsR = bicepsR;
	}
	public Double getLegL() {
		return legL;
	}
	public void setLegL(Double legL) {
		this.legL = legL;
	}
	public Double getLegR() {
		return legR;
	}
	public void setLegR(Double legR) {
		this.legR = legR;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getHip() {
		return hip;
	}
	public void setHip(Double hip) {
		this.hip = hip;
	}
	public Double getForearmL() {
		return forearmL;
	}
	public void setForearmL(Double forearmL) {
		this.forearmL = forearmL;
	}
	public Double getForearmR() {
		return forearmR;
	}
	public void setForearmR(Double forearmR) {
		this.forearmR = forearmR;
	}
	public Double getCalfL() {
		return calfL;
	}
	public void setCalfL(Double calfL) {
		this.calfL = calfL;
	}
	public Double getCalfR() {
		return calfR;
	}
	public void setCalfR(Double calfR) {
		this.calfR = calfR;
	}
	
	
}
