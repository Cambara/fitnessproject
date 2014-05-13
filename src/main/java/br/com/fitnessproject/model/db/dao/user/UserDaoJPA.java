package br.com.fitnessproject.model.db.dao.user;

import java.util.List;

import javax.persistence.EntityManager;



import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.fitnessproject.model.entity.User;
@Repository
public class UserDaoJPA implements UserDao{
	
	@PersistenceContext(unitName ="entityManager")
	private EntityManager entityManager;
	
	@Override
	public Boolean add(User user) {
		entityManager.persist(user);
		
		return false;
	}

	@Override
	public boolean update(User user) {
		return false;
	}

	@Override
	public boolean remove(Long id) {
		return false;
	}

	@Override
	public User findById(Long id) {
		return null;
	}

	@Override
	public List<User> list() {
		return null;
	}
	
}
