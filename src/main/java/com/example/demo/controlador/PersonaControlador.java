/**
 * 
 */
package com.example.demo.controlador;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Persona;
import com.example.demo.servicio.PersonaServicioImp;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

/**
 * 
 */

@RestController
@RequestMapping("/v1/personas")
public class PersonaControlador {

	private final PersonaServicioImp personaServiceImp;

	public PersonaControlador(PersonaServicioImp personaServiceImp) {
		this.personaServiceImp = personaServiceImp;
	}

	@GetMapping("/listaDePersonas")
	public ResponseEntity<List<Persona>> getAllPersonas() {
		List<Persona> personas = personaServiceImp.listaDePersonas();
		if (personas.isEmpty()) {
			return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}

	@PostMapping("/crearPersona")
	public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
		Persona personas = personaServiceImp.crearPersona(persona);
		return new ResponseEntity<>(personas, HttpStatus.CREATED);
	}

	@PutMapping("/actualizaPersona/{id}")
	public ResponseEntity<String> actualizaPersona(@PathVariable Long id, @Valid @RequestBody Persona persona,
			BindingResult result) {
		// Validar el contenido del cuerpo de la solicitud
		if (result.hasErrors()) {
			StringBuilder errorMsg = new StringBuilder("Errores de validación: ");
			result.getAllErrors().forEach(error -> errorMsg.append(error.getDefaultMessage()).append("; "));
			return ResponseEntity.badRequest().body(errorMsg.toString());
		}

		try {
			// Intentar actualizar la persona
			Persona personaActualizada = personaServiceImp.actualizarPersona(id, persona);
			return ResponseEntity.ok("Persona actualizada con éxito: " + personaActualizada);
		} catch (EntityNotFoundException e) {
			// Manejar el caso donde la entidad no se encuentra
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			// Manejar otros posibles errores
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al actualizar la persona: " + e.getMessage());
		}
	}

//	@PutMapping("/actualizaPersona/{id}")
//	public ResponseEntity<Persona> actualizaPersona(@PathVariable Long id, @RequestBody Persona persona) {
//		Persona personas = personaServiceImp.actualizarPersona(id, persona);
//		return new ResponseEntity<>(personas, HttpStatus.OK);
//	}

//	@GetMapping("/lista")
//	public List<Persona> listaPersona() {
//		return repositoryPersona.findAll();
//	}
//
//	@PostMapping("/persona")
//	public Persona crear(@RequestBody Persona persona) {
//		return repositoryPersona.save(persona);
//	}
//
//	@PutMapping("/persona")
//	public Persona update(@RequestBody Persona persona) {
//		return repositoryPersona.save(persona);
//	}
//
//	@DeleteMapping("/persona/{id}")
//	public void delete(@PathVariable Long id) {
//		logger.info("Eliminando persona con ID: {}", id);
//		repositoryPersona.deleteById(id);
//	}
//
//	@GetMapping("/buscar")
//	public void buscarPersona(@RequestParam String nombre) {
//		List<Persona> persona = repositoryPersona.findByName(nombre);
//		for (Persona persona2 : persona) {
//			logger.info("Eliminando persona con ID: {}", persona2.getNombre());
//          
//		}
//	}

}
