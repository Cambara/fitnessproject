package br.com.fitnessproject.model.db.dao.gym;

import java.util.List;

import br.com.fitnessproject.model.entity.Gym;

public class GymDaoJPA implements GymDao{

	@Override
	public boolean add(Gym gym) {
		return false;
	}

	@Override
	public boolean update(Gym gym) {
		return false;
	}

	@Override
	public boolean remove(Long id) {
		return false;
	}

	@Override
	public Gym findById(Long id) {
		return null;
	}

	@Override
	public List<Gym> list() {
		return null;
	}

}
