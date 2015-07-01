package br.com.fitnessproject.model.db.dao.historical;

import java.util.List;

import br.com.fitnessproject.model.entity.HistoricalTraining;

public interface HistoricalTrainingDao {
	public HistoricalTraining add(HistoricalTraining historicalTraining);
	public HistoricalTraining findById(Long id);
	public List<HistoricalTraining> findByUserId(Long id);
	public List<HistoricalTraining> list(Long id);
}
