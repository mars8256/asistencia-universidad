package edu.uspg.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.uspg.exception.ModeloNotFoundException;
import edu.uspg.model.CursoCatedratico;
import edu.uspg.service.ICursoCatedraticoService;

@RestController
@RequestMapping("/curso-catedratico")
public class CursoCatedraticoController {

	@Autowired
	private ICursoCatedraticoService service;
	
	/*list all*/
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CursoCatedratico>> listar(){
		return new ResponseEntity<List<CursoCatedratico>>(service.listar(), HttpStatus.OK);
	}
	
	/*list for id*/
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CursoCatedratico> listarPorId(@PathVariable("id") Integer id){
		Optional<CursoCatedratico> cursoCatedratico = service.listarPorId(id);
		if(!cursoCatedratico.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		} 
		return new ResponseEntity<CursoCatedratico>(cursoCatedratico.get(), HttpStatus.OK);
	}
	
	/*register*/
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				 consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody CursoCatedratico curCat){
		CursoCatedratico cursoCatedratico = new CursoCatedratico();
		cursoCatedratico = service.registrar(curCat);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cursoCatedratico.getIdCursoCatedratico()).toUri();
		return ResponseEntity.created(location).build();	
	}
	
	/*UPDATE*/
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, 
			    consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody CursoCatedratico curCat) {
		service.modificar(curCat);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Optional<CursoCatedratico> curCat = service.listarPorId(id);
		if(!curCat.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		} else {
			service.eliminar(id);
		}
	}
	
}















