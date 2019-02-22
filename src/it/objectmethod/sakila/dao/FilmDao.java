package it.objectmethod.sakila.dao;

import java.util.List;

import it.objectmethod.sakila.domain.Film;

public interface FilmDao {

	List <Film> findAllCategory();
	List<Film> findFilm(int category_id, String nameFilm);
}
