package it.objectmethod.sakila.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.sakila.dao.FilmDao;
import it.objectmethod.sakila.dao.impl.FilmDaoImpl;
import it.objectmethod.sakila.domain.Film;
@WebServlet("/film")
public class FilmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FilmDao filmDao = new FilmDaoImpl();
		List<Film> listaFilm = new ArrayList<>();
		String categoryIdString = request.getParameter("idCategoria");
		String idAttoreString = request.getParameter("idAttore");
		String nomeFilm = "%"+request.getParameter("nomeFilm")+"%";
		if(categoryIdString!=null){
			int idCategoria = Integer.parseInt(categoryIdString);
			listaFilm = filmDao.findFilmForFilter(idCategoria,nomeFilm);
		}
		else if(idAttoreString!=null) {
			int idAttore = Integer.parseInt(idAttoreString);
			listaFilm = filmDao.findFilmForActor(idAttore);
		}
		request.setAttribute("lista",listaFilm);
		request.getRequestDispatcher("film.jsp").forward(request, response);
	}

}
