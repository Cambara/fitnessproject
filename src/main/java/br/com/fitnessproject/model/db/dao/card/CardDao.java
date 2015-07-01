package br.com.fitnessproject.model.db.dao.card;

import java.util.List;

import br.com.fitnessproject.model.entity.Card;

public interface CardDao {
	public Card add(Card card);
	public Card update(Card card);
	public boolean remove(Long id);
	public Card findById(Long id);
	public List<Card> list(Long id);
}
