/**
 * 
 */
package com.example.demo.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Producto;
import com.example.demo.servicio.ServicioImp;

/**
 * 
 */

@RestController
@RequestMapping("/v1/productos")
public class ProductoControlador {

	public ServicioImp servicioImp;

	public ProductoControlador(ServicioImp servicioImp) {
		this.servicioImp = servicioImp;
	}

	@GetMapping("/orderAsc")
	public List<Producto> getAllProductByOrderAsc() {
		return servicioImp.getAllProductByOrderAsc();
	}

	@GetMapping("/isActive/{isActive}")
	public List<Producto> getProductByIsActive(@PathVariable boolean isActive) {
		return servicioImp.getProductByIsActive(isActive);
	}

	@PostMapping
	public Producto addProduct(@RequestBody Producto producto) {
		return servicioImp.createProduct(producto);
	}

}
