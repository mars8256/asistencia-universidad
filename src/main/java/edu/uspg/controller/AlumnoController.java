package edu.uspg.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.uspg.exception.ModeloNotFoundException;
import edu.uspg.model.Alumno;
import edu.uspg.service.IAlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private IAlumnoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Alumno>> listar(){
		return new ResponseEntity<List<Alumno>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alumno> listarPorId(@PathVariable("id") Integer id){
		Optional<Alumno> alumno = service.listarPorId(id);
		if(!alumno.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}
		return new ResponseEntity<Alumno>(alumno.get(),HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody Alumno alumn) {
		Alumno alumno = new Alumno();
		alumno = service.registrar(alumn);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alumno.getIdAlumno()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Alumno alumn){
		service.modificar(alumn);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}









