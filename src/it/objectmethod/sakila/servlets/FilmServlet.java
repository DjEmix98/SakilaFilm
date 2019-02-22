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
		List<Film> listaCategoria = new ArrayList<>();
		String categoryIdString = request.getParameter("idCategoria");
		String nomeFilm = "%"+request.getParameter("nomeFilm")+"%";
		int idCategoria = Integer.parseInt(categoryIdString);
		listaCategoria = filmDao.findFilm(idCategoria,nomeFilm);
		request.setAttribute("lista",listaCategoria);
		request.getRequestDispatcher("film.jsp").forward(request, response);
	}

}
