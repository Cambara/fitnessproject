package br.com.fitnessproject.model.db.dao.gym;

import java.util.List;

import br.com.fitnessproject.model.entity.Gym;

public interface GymDao {
	
	public boolean add(Gym gym);
	public boolean update(Gym gym);
	public boolean remove(Long id);
	public Gym findById(Long id);
	public List<Gym> list();
}
