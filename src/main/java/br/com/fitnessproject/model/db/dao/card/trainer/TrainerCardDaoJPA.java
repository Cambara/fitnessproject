package br.com.fitnessproject.model.db.dao.card.trainer;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fitnessproject.model.entity.TrainerCard;
@Repository
public class TrainerCardDaoJPA implements TrainerCardDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public TrainerCard add(TrainerCard trainerCard) {
		em.persist(trainerCard);
		return trainerCard;
	}

	@Override
	@Transactional
	public TrainerCard update(TrainerCard trainerCard) {
		em.merge(trainerCard);
		return trainerCard;
	}

	@Override
	@Transactional
	public boolean remove(Long id) {
		TrainerCard trainerCard = findById(id);
		boolean removed = trainerCard != null;
		if(removed){
			em.remove(trainerCard);
		}
		return removed;
	}

	@Override
	@Transactional
	public TrainerCard findById(Long id) {
		return em.find(TrainerCard.class, id);
	}
	@Override
	@Transactional
	public List<TrainerCard> list(Long id) {
		String hql = "SELECT t FROM TrainerCard t WHERE t.card.id = :l ORDER BY t.lastTrainer";
		TypedQuery<TrainerCard> query = em.createQuery(hql, TrainerCard.class);
		query.setParameter("l", id);
		return  query.getResultList();
	}
	@Override
	@Transactional
	public TrainerCard getNextTrainer(Long id){
		String hqlCard = " SELECT c.id FROM Card c WHERE c.user.id = :l AND c.dateEnd >= CURRENT_DATE()";
		String hql = "SELECT t FROM TrainerCard t WHERE t.card.id=(:cardId) ORDER BY t.lastTrainer";
		TrainerCard trainerCard= null;
		try {
			TypedQuery<Long> queryCard = em.createQuery(hqlCard,Long.class);
			queryCard.setParameter("l", id);
			queryCard.setFirstResult(0);
			queryCard.setMaxResults(1);
			TypedQuery<TrainerCard> query = em.createQuery(hql, TrainerCard.class);
			query.setParameter("cardId", queryCard.getSingleResult());
			query.setFirstResult(0);
			query.setMaxResults(1);
			trainerCard = query.getSingleResult();
		} catch (Exception e) {
			trainerCard = new TrainerCard();
		}
		return trainerCard;
	}

}
