/**
 * 
 */
package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Persona;

/**
 * 
 */

@Repository
public interface RepositorioPersona extends JpaRepository<Persona, Long> {

	@Query("SELECT p FROM Persona p WHERE p.nombre = :nombre")
	public List<Persona> findByName(String nombre);

	@Query("SELECT COUNT(p) > 0 FROM Persona p WHERE p.nombre = :nombre")
	boolean existsByNombre(String nombre);

}
