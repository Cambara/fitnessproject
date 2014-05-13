package br.com.fitnessproject.model.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="photo")
public class Photo {
	@Id@GeneratedValue
	private Long id;
	@Column
	private byte[] bytes;
	
	// gets e sets
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	
	
	
}
