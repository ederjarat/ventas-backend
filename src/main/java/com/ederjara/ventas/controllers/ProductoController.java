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
import com.ederjara.ventas.models.Producto;
import com.ederjara.ventas.services.ProductoService;

@Controller
@RequestMapping(value="/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listar(){
		return new ResponseEntity<List<Producto>>(productoService.listar(), HttpStatus.OK);
	}
	
	 @GetMapping("/{id}")
		public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) {
		 Producto producto = productoService.leer(id);
			if(producto == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
			}
			return new ResponseEntity<Producto>(producto,HttpStatus.OK);
		}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Producto producto){
		Producto product = productoService.registrar(producto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getIdProducto()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Producto producto) {
		productoService.modificar(producto);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Producto producto = productoService.leer(id);
		if (producto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			productoService.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
