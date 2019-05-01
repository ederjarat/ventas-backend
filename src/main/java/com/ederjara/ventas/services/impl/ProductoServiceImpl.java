package com.ederjara.ventas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ederjara.ventas.models.Producto;
import com.ederjara.ventas.repositories.ProductoRepository;
import com.ederjara.ventas.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	@Override
	public Producto registrar(Producto entity) {		
		return productoRepository.save(entity);
	}

	@Override
	public Producto modificar(Producto entity) {	
		return productoRepository.save(entity);
	}

	@Override
	public Producto leer(Integer id) {		
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Producto> listar() {		
		return productoRepository.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		productoRepository.deleteById(id);		
	}

	
}
