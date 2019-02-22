package it.objectmethod.sakila.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.sakila.dao.CategoriaDao;
import it.objectmethod.sakila.dao.impl.CategoriaDaoImpl;
import it.objectmethod.sakila.domain.Categoria;
@WebServlet("/ricerca")
public class FormRicercaFilmServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoriaDao categoriaDao = new CategoriaDaoImpl();
		List<Categoria> listaCategoria = new ArrayList<>();
		listaCategoria = categoriaDao.findAllCategory();
		request.setAttribute("lista",listaCategoria);
		request.getRequestDispatcher("ricerca-film.jsp").forward(request, response);
	}

}
