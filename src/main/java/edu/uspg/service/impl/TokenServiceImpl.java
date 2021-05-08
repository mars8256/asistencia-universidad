package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.ITokenDAO;
import edu.uspg.model.Token;
import edu.uspg.service.ITokenService;

@Service
public class TokenServiceImpl implements ITokenService {

	@Autowired
	private ITokenDAO dao;
	
	@Override
	public Token registrar(Token t) {
		return dao.save(t);
	}

	@Override
	public Token modificar(Token t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Token> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Token> listar() {
		return dao.findAll();
	}

}
