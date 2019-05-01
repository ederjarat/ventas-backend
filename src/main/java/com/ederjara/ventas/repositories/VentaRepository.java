package com.ederjara.ventas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederjara.ventas.models.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

}
