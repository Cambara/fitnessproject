package br.com.fitnessproject.model.db.dao.gym;

import java.util.List;

import br.com.fitnessproject.model.entity.Gym;
import br.com.fitnessproject.model.entity.Login;

public interface GymDao {
	
	public Gym add(Gym gym);
	public Gym update(Gym gym);
	public boolean remove(Long id);
	public Gym findById(Long id);
	public List<Gym> list();
	public Gym findByLogin(Login l);
}
