package it.objectmethod.sakila.dao;

import java.util.List;

import it.objectmethod.sakila.domain.Film;

public interface FilmDao {

	List<Film> findFilmForFilter(int category_id, String nameFilm);
	List<Film> findFilmForActor(int idActor);
}
