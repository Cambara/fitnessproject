package br.com.fitnessproject.model.db.dao.exercisename;

import java.util.List;

import br.com.fitnessproject.model.entity.ExerciseName;

public interface ExerciseNameDao {
	
	public boolean add(ExerciseName exerciseName);
	public boolean update(ExerciseName exerciseName);
	public boolean remove(Long id);
	public ExerciseName findById(Long id);
	public List<ExerciseName> list();
}
