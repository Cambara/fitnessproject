package br.com.fitnessproject.model.db.dao.exercisename;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.fitnessproject.model.entity.ExerciseName;
@Repository
public class ExerciseNameDaoJPA implements ExerciseNameDao{
	
	@Override
	public boolean add(ExerciseName exerciseName) {
	
		return false;
	}

	@Override
	public boolean update(ExerciseName exerciseName) {
		return false;
	}

	@Override
	public boolean remove(Long id) {
		return false;
	}

	@Override
	public ExerciseName findById(Long id) {
		return null;
	}

	@Override
	public List<ExerciseName> list() {
		return null;
	}

}
