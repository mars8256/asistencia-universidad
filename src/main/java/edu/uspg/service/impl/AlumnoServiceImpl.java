package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IAlumnoDAO;
import edu.uspg.model.Alumno;
import edu.uspg.service.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	private IAlumnoDAO dao;
	
	@Override
	public Alumno registrar(Alumno t) {
		return dao.save(t);
	}

	@Override
	public Alumno modificar(Alumno t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Alumno> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Alumno> listar() {
		return dao.findAll();
	}

}
