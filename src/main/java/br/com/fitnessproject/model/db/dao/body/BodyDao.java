package br.com.fitnessproject.model.db.dao.body;

import java.util.List;

import br.com.fitnessproject.model.entity.Body;

public interface BodyDao {
	public Body add(Body body);
	public Body update(Body body);
	public Body getByUserId(Long id);
	public List<Body> listByUserId(Long id);
}
