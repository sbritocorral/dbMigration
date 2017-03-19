package prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Mensaje implements Queryable{
	
	private String tabla = "mensajes";
	
	private int codigo;
	private String mensaje;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	
	@Override
	public String toString() {
		return "Mensaje [codigo=" + codigo + ", mensaje=" + mensaje + "]";
	}
	
	
	
	@Override
	public Object toQuery(String dbType, Connection con) {
		
		String query = null;
		
		query = "INSERT INTO mensajes (codigo, mensaje) values (?,?)";
		try {
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, this.codigo);
			statement.setString(2, this.mensaje);
			

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
			String sql = "DELETE from mensajes ;";
			stmt = con.prepareStatement(sql);			
		  
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return stmt;
	}
	
	
	
	
	

}
