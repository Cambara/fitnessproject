package br.com.fitnessproject.model.db.dao.historical;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fitnessproject.model.entity.Card;
import br.com.fitnessproject.model.entity.HistoricalTraining;

@Repository
public class HistoricalTrainingDaoJPA implements HistoricalTrainingDao{
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional
	public HistoricalTraining add(HistoricalTraining historicalTraining) {
		em.persist(historicalTraining);
		return historicalTraining;
	}

	@Override
	public HistoricalTraining findById(Long id) {
		return em.find(HistoricalTraining.class, id);
	}

	@Override
	public List<HistoricalTraining> findByUserId(Long id) {
		String hql = "SELECT h FROM HistoricalTraining h "
				+ "WHERE h.trainerCard.card.user.id = :l ORDER BY h.date DESC";
		TypedQuery<HistoricalTraining> query = em.createQuery(hql, HistoricalTraining.class);
		query.setParameter("l", id);
		return  query.getResultList();
	}

	@Override
	public List<HistoricalTraining> list(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
