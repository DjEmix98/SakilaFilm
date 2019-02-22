package it.objectmethod.sakila.dao;

import java.util.List;

import it.objectmethod.sakila.domain.Categoria;

public interface CategoriaDao {

	List<Categoria> findAllCategory();
}
