package it.objectmethod.sakila.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.sakila.dao.AttoriDao;
import it.objectmethod.sakila.dao.impl.AttoriDaoImpl;
import it.objectmethod.sakila.domain.Attore;

@WebServlet("/attori")
public class AttoriServlet  extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AttoriDao attoriDao = new AttoriDaoImpl();
		List<Attore> listaAttori = new ArrayList<>();
		String idFilmString = request.getParameter("idFilm");
		int idFilm = Integer.parseInt(idFilmString);
		listaAttori = attoriDao.findAttori(idFilm);
		request.setAttribute("listaAttori", listaAttori);
		request.getRequestDispatcher("attori.jsp").forward(request, response);
	}
}
