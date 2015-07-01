package br.com.fitnessproject.model.db.dao.body;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fitnessproject.model.entity.Body;
import br.com.fitnessproject.model.entity.User;

@Repository
public class BodyJPA implements BodyDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	@Override
	public Body add(Body body) {
		em.persist(body);
		return body;
	}
	
	@Transactional
	@Override
	public Body update(Body body) {
		em.merge(body);
		return body;
	}

	@Override
	public Body getByUserId(Long id) {
		String hql = "SELECT b FROM Body b WHERE b.user.id = :l ORDER BY b.id DESC";
		TypedQuery<Body> query = em.createQuery(hql, Body.class);
		query.setParameter("l", id);
		Body b = null;
		try {
			query.setFirstResult(0);
			query.setMaxResults(1);
			b = query.getSingleResult();
		} catch (Exception e) {
			b = new Body();
			b.setUser(new User());
		}
		return b;
	}

	@Override
	public List<Body> listByUserId(Long id) {
		String hql = "SELECT b FROM Body b WHERE b.user.id = :l ORDER BY b.date DESC";
		TypedQuery<Body> query = em.createQuery(hql, Body.class);
		query.setParameter("l", id);
		return query.getResultList();
	}

}
