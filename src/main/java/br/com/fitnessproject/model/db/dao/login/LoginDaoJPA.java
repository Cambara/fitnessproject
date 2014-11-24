package br.com.fitnessproject.model.db.dao.login;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fitnessproject.model.entity.Login;
@Repository
public class LoginDaoJPA implements LoginDao{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public Login add(Login login) {
		em.persist(login);
		return login;
	}

	@Override
	@Transactional
	public Login update(Login login) {
		em.merge(login);
		return login;
	}

	@Override
	@Transactional
	public boolean remove(Long id) {
		Login login = em.find(Login.class, id);
		boolean removed = login != null;
		if(removed){
			em.remove(login);
		}
		return removed;
	}

	@Override
	public Login findById(Long id) {
		return em.find(Login.class, id);
	}
	@Override 
	public Login findByEmail(String email){
		TypedQuery<Login> query = em.createQuery("SELECT l FROM Login l WHERE l.email = :email", Login.class);
		query.setParameter("email", email);
		Login l = null; 
		try {
			l = (Login) query.getSingleResult();			
		} catch (Exception e) {}
		return  l;
	}

	@Override
	public List<Login> list() {
		TypedQuery<Login> query = em.createQuery("SELECT l FROM Login l", Login.class);
		return query.getResultList();
	}

}
