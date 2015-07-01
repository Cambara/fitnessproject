package br.com.fitnessproject.model.db.dao.card.trainer;

import java.util.List;


import br.com.fitnessproject.model.entity.TrainerCard;

public interface TrainerCardDao {
	public TrainerCard add(TrainerCard trainerCard);
	public TrainerCard update(TrainerCard trainerCard);
	public boolean remove(Long id);
	public TrainerCard findById(Long id);
	public List<TrainerCard> list(Long id);
	public TrainerCard getNextTrainer(Long id);
}
