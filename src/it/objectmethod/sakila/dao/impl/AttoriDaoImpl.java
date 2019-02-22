package it.objectmethod.sakila.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.sakila.config.ConnectionConfig;
import it.objectmethod.sakila.dao.AttoriDao;
import it.objectmethod.sakila.domain.Attore;

public class AttoriDaoImpl implements AttoriDao{

	@Override
	public List<Attore> findAttori(int idFilm) {
		List<Attore> listaAttori = new ArrayList<>();
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		try {
		String sql = "select a.* from actor as a inner join film_actor as fa on a.actor_id=fa.actor_id where fa.film_id =?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, idFilm);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			Attore attore = new Attore();
			attore.setId(rs.getInt("actor_id"));
			attore.setNome(rs.getString("first_name"));
			attore.setCognome(rs.getString("last_name"));
			attore.setLast_update(rs.getString("last_update"));
			listaAttori.add(attore);
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
	return listaAttori;
	}

}
