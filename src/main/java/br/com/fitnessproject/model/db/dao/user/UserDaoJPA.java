package br.com.fitnessproject.model.db.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fitnessproject.model.entity.User;
@Repository
public class UserDaoJPA implements UserDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public Boolean add(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
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
