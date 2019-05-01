package com.ederjara.ventas.services;

import java.util.List;

public interface CrudService<T> {

	T registrar(T entity);
	T modificar(T entity);
	T leer(Integer id);
	List<T> listar();
	void eliminar(Integer id);
}
