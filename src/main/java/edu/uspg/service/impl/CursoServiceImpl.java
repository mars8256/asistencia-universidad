package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.ICursoDAO;
import edu.uspg.model.Curso;
import edu.uspg.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private ICursoDAO dao;
	
	@Override
	public Curso registrar(Curso t) {
		return dao.save(t);
	}

	@Override
	public Curso modificar(Curso t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Curso> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Curso> listar() {
		return dao.findAll();
	}

}
