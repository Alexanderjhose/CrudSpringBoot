package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Persona;

public interface PersonaServicio {

	public List<Persona> listaDePersonas();

	public Persona crearPersona(Persona persona);

	public Persona actualizarPersona(Long id, Persona persona);

}
