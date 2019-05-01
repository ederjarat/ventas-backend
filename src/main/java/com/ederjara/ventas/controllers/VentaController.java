package com.ederjara.ventas.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ederjara.ventas.exceptions.ModeloNotFoundException;
import com.ederjara.ventas.models.Venta;
import com.ederjara.ventas.services.VentaService;

@Controller
@RequestMapping(value="/ventas")
public class VentaController {

	@Autowired
	private VentaService ventaService;
	
	@GetMapping
	public ResponseEntity<List<Venta>> listar(){
		return new ResponseEntity<List<Venta>>(ventaService.listar(), HttpStatus.OK);
	}
	
	 @GetMapping("/{id}")
		public ResponseEntity<Venta> listarPorId(@PathVariable("id") Integer id) {
		 Venta venta = ventaService.leer(id);
			if(venta == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
			}
			return new ResponseEntity<Venta>(venta,HttpStatus.OK);
		}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Venta venta){
		Venta product = ventaService.registrar(venta);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Venta venta) {
		ventaService.modificar(venta);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Venta venta = ventaService.leer(id);
		if (venta == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			ventaService.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
