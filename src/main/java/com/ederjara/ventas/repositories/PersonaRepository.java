package com.ederjara.ventas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederjara.ventas.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
