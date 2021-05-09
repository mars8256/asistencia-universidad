package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.ICatedraticoDAO;
import edu.uspg.model.Catedratico;
import edu.uspg.service.ICatedraticoService;

@Service
public class CatedraticoServiceImpl implements ICatedraticoService {

	@Autowired
	private ICatedraticoDAO dao;
	
	@Override
	public Catedratico registrar(Catedratico t) {
		return dao.save(t);
	}

	@Override
	public Catedratico modificar(Catedratico t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Catedratico> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Catedratico> listar() {
		return dao.findAll();
	}

}
