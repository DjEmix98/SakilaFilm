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
	public List<Film> findFilmForFilter(int category_id,String nameFilm) {
		List<Film> listaFilm = new ArrayList<>();
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select f.* from film as f inner join film_category as fc on f.film_id=fc.film_id where (fc.category_id=? or ?=0) and f.title like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, category_id);
			stmt.setInt(2, category_id);
			stmt.setString(3, nameFilm);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Film Film = new Film();
				Film.setId(rs.getInt("film_id"));
				Film.setName(rs.getString("title"));
				Film.setLast_update(rs.getString("last_update"));
				Film.setDescrizione(rs.getString("description"));
				Film.setYear(rs.getInt("release_year"));
				listaFilm.add(Film);
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
		return listaFilm;
	}

	@Override
	public List<Film> findFilmForActor(int idActor) {
		List<Film> listaFilm = new ArrayList<>();
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select f.* from film as f inner join film_actor as fc on f.film_id=fc.film_id where fc.actor_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idActor);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Film Film = new Film();
				Film.setId(rs.getInt("film_id"));
				Film.setName(rs.getString("title"));
				Film.setLast_update(rs.getString("last_update"));
				Film.setDescrizione(rs.getString("description"));
				Film.setYear(rs.getInt("release_year"));
				listaFilm.add(Film);
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
		return listaFilm;
	}


}
