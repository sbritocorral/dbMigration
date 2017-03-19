package prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Grupo implements Queryable{

	private String tabla = "grupos";
	private String codigo;
	private String descripcion;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	@Override
	public String toString() {
		return "Grupo [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	
	@Override
	public Object toQuery(String dbType, Connection con) {
		
		String query = null;
		
		query = "INSERT INTO grupos (codigo, descripcion) values (?,?)";
		try {
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setString(1, this.codigo);
			statement.setString(2, this.descripcion);
			

			return statement;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
				
		return query;
	}
	@Override
	public Object beforeInsert(String dbType, Connection con) {
	
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE from grupos ;";
			stmt = con.prepareStatement(sql);			
		  
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
					
		return stmt;
	}
	
	
	
}
