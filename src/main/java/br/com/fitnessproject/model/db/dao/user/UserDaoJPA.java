package br.com.fitnessproject.model.db.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.fitnessproject.model.entity.User;
@Repository
public class UserDaoJPA implements UserDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Boolean add(User user) {
		
		entityManager.persist(user);
		
		return true;
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
