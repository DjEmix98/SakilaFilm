package it.objectmethod.sakila.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.sakila.config.ConnectionConfig;
import it.objectmethod.sakila.dao.FilmDao;
import it.objectmethod.sakila.domain.Film;

public class FilmDaoImpl implements FilmDao {

	@Override
	public List<Film> findFilm(int category_id,String nameFilm) {
		List<Film> listaIdFilm = new ArrayList<>();
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT * FROM sakila.film_category inner join film on film_category.film_id=film.film_id where film_category.category_id=? and title LIKE ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, category_id);
			stmt.setString(2, nameFilm);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Film idFilm = new Film();
				idFilm.setId(rs.getInt("film_id"));
				idFilm.setName(rs.getString("title"));
				idFilm.setLast_update(rs.getString("last_update"));
				idFilm.setDescrizione(rs.getString("description"));
				idFilm.setYear(rs.getInt("release_year"));
				listaIdFilm.add(idFilm);
			}

			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null) {
					stmt.close();
				}				
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{
				if(conn!=null) {
					conn.close();
				}	
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return listaIdFilm;
	}


}
