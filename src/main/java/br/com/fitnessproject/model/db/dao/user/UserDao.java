package br.com.fitnessproject.model.db.dao.user;

import java.util.List;

import br.com.fitnessproject.model.entity.User;



public interface UserDao {
	
	public Boolean add(User user);
	public boolean update(User user);
	public boolean remove(Long id);
	public User findById(Long id);
	public List<User> list();
}
