package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.ICursoCatedraticoDAO;
import edu.uspg.model.CursoCatedratico;
import edu.uspg.service.ICursoCatedraticoService;

@Service
public class CursoCatedraticoServiceImpl implements ICursoCatedraticoService {

	@Autowired
	private ICursoCatedraticoDAO dao;
	
	@Override
	public CursoCatedratico registrar(CursoCatedratico t) {
		return dao.save(t);
	}

	@Override
	public CursoCatedratico modificar(CursoCatedratico t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<CursoCatedratico> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<CursoCatedratico> listar() {
		return dao.findAll();
	}

}
