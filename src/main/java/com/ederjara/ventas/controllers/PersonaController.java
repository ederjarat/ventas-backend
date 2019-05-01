package com.ederjara.ventas.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ederjara.ventas.exceptions.ModeloNotFoundException;
import com.ederjara.ventas.models.Persona;
import com.ederjara.ventas.services.PersonaService;


@Controller
@RequestMapping(value="/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
    @GetMapping
	public ResponseEntity<List<Persona>> listar(){
		return new ResponseEntity<List<Persona>>(personaService.listar(), HttpStatus.OK);
	}
    
    @GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) {
    	Persona persona = personaService.leer(id);
		if(persona == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<Persona>(persona,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Persona persona){
		Persona person = personaService.registrar(persona);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getIdPersona()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Persona persona) {
		personaService.modificar(persona);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Persona person = personaService.leer(id);
		if (person == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			personaService.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
