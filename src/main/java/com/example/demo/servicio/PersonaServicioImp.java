/**
 * 
 */
package com.example.demo.servicio;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.Persona;
import com.example.demo.repositorio.RepositorioPersona;

/**
 * 
 */

@Service
public class PersonaServicioImp implements PersonaServicio {

	private final RepositorioPersona repositoryPersona;

	public PersonaServicioImp(RepositorioPersona repositoryPersona) {
		this.repositoryPersona = repositoryPersona;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> listaDePersonas() {
		return repositoryPersona.findAll();
	}

	@Override
	@Transactional
	public Persona crearPersona(Persona persona) {
		return repositoryPersona.save(persona);
	}

	@Override
	@Transactional
	public Persona actualizarPersona(Long id, Persona persona) {

		Persona personaExiste = repositoryPersona.findById(id).orElseThrow();

		personaExiste.setNombre(persona.getNombre());
		personaExiste.setAyer(persona.getAyer());

		return repositoryPersona.save(personaExiste);
	}

}
