package it.objectmethod.sakila.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.sakila.config.ConnectionConfig;
import it.objectmethod.sakila.dao.CategoriaDao;
import it.objectmethod.sakila.domain.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {

	@Override
	public List<Categoria> findAllCategory() {
		List<Categoria> listaCategoria = new ArrayList<>();
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT * FROM category";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Categoria categoriaFilm = new Categoria();
				categoriaFilm.setId(rs.getInt("category_id"));
				categoriaFilm.setName(rs.getString("name"));
				categoriaFilm.setLast_update(rs.getString("last_update"));
				listaCategoria.add(categoriaFilm);
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
		return listaCategoria;
	}

	
}
