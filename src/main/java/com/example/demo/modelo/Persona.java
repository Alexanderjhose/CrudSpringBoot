/**
 * 
 */
package com.example.demo.modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
  
/**
 * 
 */

@Entity
@Table(name = "Persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
	private String nombre;

	private int ayer;

	public Persona() {
	}

	public Persona(Long id, String nombre, int ayer) {
		this.id = id;
		this.nombre = nombre;
		this.ayer = ayer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAyer() {
		return ayer;
	}

	public void setAyer(int ayer) {
		this.ayer = ayer;
	}

}
