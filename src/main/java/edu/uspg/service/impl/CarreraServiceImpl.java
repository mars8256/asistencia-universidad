package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.ICarreraDAO;
import edu.uspg.model.Carrera;
import edu.uspg.service.ICarreraService;

@Service
public class CarreraServiceImpl implements ICarreraService {

	@Autowired
	private ICarreraDAO dao;
	
	@Override
	public Carrera registrar(Carrera t) {
		return dao.save(t);
	}

	@Override
	public Carrera modificar(Carrera t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Carrera> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Carrera> listar() {
		return dao.findAll();
	}

}
