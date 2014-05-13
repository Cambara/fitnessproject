package br.com.fitnessproject.model.db.dao.login;

import java.util.List;

import br.com.fitnessproject.model.entity.Login;

public class LoginDaoJPA implements LoginDao{

	@Override
	public boolean add(Login login) {
		return false;
	}

	@Override
	public boolean update(Login login) {
		return false;
	}

	@Override
	public boolean remove(Long id) {
		return false;
	}

	@Override
	public Login findById(Long id) {
		return null;
	}

	@Override
	public List<Login> list() {
		return null;
	}

}
