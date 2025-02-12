/**
 * 
 */
package com.example.demo.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/lista")
	public List<Producto> ListProduct() {
		return servicioImp.listaProducto();
	}

}
