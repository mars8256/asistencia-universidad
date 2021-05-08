package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IFacultadDAO;
import edu.uspg.model.Facultad;
import edu.uspg.service.IFacultadService;

@Service
public class FacultadServiceImpl implements IFacultadService {

	@Autowired
	private IFacultadDAO dao;
	
	
	@Override
	public Facultad registrar(Facultad t) {
		return dao.save(t);
	}

	@Override
	public Facultad modificar(Facultad t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Facultad> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Facultad> listar() {
		return dao.findAll();
	}

}
