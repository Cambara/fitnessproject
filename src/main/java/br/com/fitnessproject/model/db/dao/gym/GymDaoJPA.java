package br.com.fitnessproject.model.db.dao.gym;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fitnessproject.model.entity.Gym;
import br.com.fitnessproject.model.entity.Login;
@Repository
public class GymDaoJPA implements GymDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Gym add(Gym gym) {
		entityManager.persist(gym);
		return gym;
	}

	@Override
	@Transactional
	public Gym update(Gym gym) {
		return gym;
	}

	@Override
	@Transactional
	public boolean remove(Long id) {
		Gym gym = entityManager.find(Gym.class, id);
		boolean removed = gym != null;
		if(removed){
			entityManager.remove(gym);
		}
		return removed;
	}

	@Override
	public Gym findById(Long id) {
		return entityManager.find(Gym.class, id);
	}

	@Override
	public List<Gym> list() {
		TypedQuery<Gym> query = entityManager.createQuery("SELECT g FROM Gym g", Gym.class);
		return query.getResultList();
	}
	
	@Override 
	public Gym findByLogin(Login l){
		TypedQuery<Gym> query = entityManager.createQuery("SELECT g FROM Gym g WHERE g.login = :l", Gym.class);
		query.setParameter("l", l);
		Gym g = null; 
		try {
			g = (Gym) query.getSingleResult();
		} catch (Exception e) {	}
		return  g;
	}

}
