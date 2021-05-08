package edu.uspg.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
import edu.uspg.model.Token;
import edu.uspg.service.ITokenService;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private ITokenService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Token>> listar(){
		return new ResponseEntity<List<Token>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Token> listarPorId(@PathVariable("id") Integer id){
		Optional<Token> token = service.listarPorId(id);
		if(!token.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}
		return new ResponseEntity<Token>(token.get(),HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody Token tok) {
		Token token = new Token();
		Random generadorAleatorios = new Random();
		int numeroAleatorio = 100+generadorAleatorios.nextInt(1000);
		int numeroAleatorio2 = 100+generadorAleatorios.nextInt(1000);
		int numeroAleatorio3 = 100+generadorAleatorios.nextInt(1000);
		//System.out.println(numeroAleatorio + "" + numeroAleatorio2 + "" + numeroAleatorio3);
		tok.setToken(tok.getToken() + "" + numeroAleatorio + "" + numeroAleatorio2 + "" + numeroAleatorio3);
		//System.out.println(tok.getToken());
		token = service.registrar(tok);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(token.getIdToken()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Token token){
		service.modificar(token);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
