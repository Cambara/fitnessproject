package br.com.fitnessproject.model.db.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fitnessproject.model.entity.Login;
import br.com.fitnessproject.model.entity.User;
@Repository
public class UserDaoJPA implements UserDao{
	
	@PersistenceContext
	private EntityManager entityManager; 
	
	
	@Transactional
	public User add(User user) {
		entityManager.persist(user);
		return user;
	}

	@Override
	@Transactional
	public User update(User user) {
		entityManager.merge(user);
		return user;
	}

	@Override
	@Transactional
	public boolean remove(Long id) {
		User user = entityManager.find(User.class, id);
		boolean removed = user != null;
		if(removed){
			entityManager.remove(user);
		}
		return removed;
	}

	@Override
	public User findById(Long id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	@Override
	public List<User> list() {
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
		return query.getResultList();
	}
	
	@Override 
	public User findByLogin(Login l){
		Long id = l.getId();
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.login.id = :l", User.class);
		query.setParameter("l", id);
		User u = null; 
		try {
			u = (User) query.getSingleResult();
		} catch (Exception e) {	}
		return  u;
	}
	
}
