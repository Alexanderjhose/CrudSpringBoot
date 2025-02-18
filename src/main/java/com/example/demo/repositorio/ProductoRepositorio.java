package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

	@Query("SELECT p FROM Producto p ORDER BY p.id ASC")
	List<Producto> findAllOrderByIdAsc();

//	@Query("SELECT p FROM Producto p WHERE ORDER BY p.id ASC p.isActivo = :isActivo")
//	List<Producto> findByIsActivo(@Param("isActivo") boolean isActivo);
	
	List<Producto> findByIsActivo(boolean isActivo);

}
