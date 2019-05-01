package com.ederjara.ventas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ederjara.ventas.models.Persona;
import com.ederjara.ventas.repositories.PersonaRepository;
import com.ederjara.ventas.services.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public Persona registrar(Persona entity) {	
		return personaRepository.save(entity);
	}

	@Override
	public Persona modificar(Persona entity) {		
		return personaRepository.save(entity);
	}

	@Override
	public Persona leer(Integer id) {		
		return personaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Persona> listar() {		
		return personaRepository.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		personaRepository.deleteById(id);		
	}

}
