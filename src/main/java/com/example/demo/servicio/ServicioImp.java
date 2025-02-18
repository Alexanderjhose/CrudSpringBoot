package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repositorio.ProductoRepositorio;

@Service
public class ServicioImp {

	private ProductoRepositorio repositorio;

	public ServicioImp(ProductoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	public List<Producto> getAllProductByOrderAsc() {
		return repositorio.findAllOrderByIdAsc();
	}

	public List<Producto> getProductByIsActive(boolean isActive) {
		return repositorio.findByIsActivo(isActive);
	}

	public Producto createProduct(Producto producto) {
		return repositorio.save(producto);
	}

}
