package br.com.fitnessproject.model.db.dao.card;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fitnessproject.model.entity.Card;
import br.com.fitnessproject.model.entity.User;

@Repository
public class CardDaoJPA implements CardDao{
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional
	public Card add(Card card) {
		em.persist(card);
		return card;
	}

	@Override
	@Transactional
	public Card update(Card card) {
		em.merge(card);
		return card;
	}

	@Override
	@Transactional
	public boolean remove(Long id) {
		Card card = findById(id);
		boolean removed = card != null;
		if(removed){
			em.remove(card);
		}
		return removed;
	}

	@Override
	@Transactional
	public Card findById(Long id) {
		return em.find(Card.class, id);
	}
	
	@Override
	@Transactional
	public List<Card> list(Long id) {
		String hql = "SELECT c FROM Card c WHERE c.user.id = :l AND c.dateEnd >= CURRENT_DATE() ORDER BY c.dateBegin";
		TypedQuery<Card> query = em.createQuery(hql, Card.class);
		query.setParameter("l", id);
		return  query.getResultList();
	}

}
