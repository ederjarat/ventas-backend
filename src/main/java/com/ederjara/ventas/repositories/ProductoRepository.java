package com.ederjara.ventas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederjara.ventas.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
