package it.objectmethod.sakila.dao;

import java.util.List;

import it.objectmethod.sakila.domain.Attore;

public interface AttoriDao {

	List<Attore> findAttori(int idFilm);
}
