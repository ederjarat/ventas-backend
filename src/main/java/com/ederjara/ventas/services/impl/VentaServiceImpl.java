package com.ederjara.ventas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ederjara.ventas.models.Venta;
import com.ederjara.ventas.repositories.VentaRepository;
import com.ederjara.ventas.services.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaRepository ventaRepository;
	@Override
	public Venta registrar(Venta venta) {
		venta.getDetalleVenta().forEach(det -> det.setVenta(venta));
		return ventaRepository.save(venta);
	}

	@Override
	public Venta modificar(Venta entity) {
		return ventaRepository.save(entity);
	}

	@Override
	public Venta leer(Integer id) {
		return ventaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Venta> listar() {		
		return ventaRepository.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		ventaRepository.deleteById(id);
		
	}

}
