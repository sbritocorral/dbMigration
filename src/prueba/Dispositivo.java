package prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Dispositivo implements Queryable{

	private String tabla = "dispositivos";
	private String codigo_vendedor;
	private String imei;
	private String activado;
	private String prefijo;
	private int secuencia;
	public String getCodigo_vendedor() {
		return codigo_vendedor;
	}
	public void setCodigo_vendedor(String codigo_vendedor) {
		this.codigo_vendedor = codigo_vendedor;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getActivado() {
		return activado;
	}
	public void setActivado(String activado) {
		this.activado = activado;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public int getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(int secuencia) {
		this.secuencia = secuencia;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	@Override
	public String toString() {
		return "Dispositivo [codigo_vendedor=" + codigo_vendedor + ", imei=" + imei + ", activado=" + activado
				+ ", prefijo=" + prefijo + ", secuencia=" + secuencia + "]";
	}
	
	
	@Override
	public Object toQuery(String dbType, Connection con) {
			
		String query = null;
		
		// En esta linea el codigo no es tan largo la ultima parte comparado con items
		query = "INSERT INTO dispositivos (codigo_vendedor, imei, activado, prefijo, secuencia) values (?,?,?,?,?)";
		try {
			
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, this.codigo_vendedor);
			statement.setString(2, this.imei);
			statement.setString(3, this.activado);
			statement.setString(4, this.prefijo);
			statement.setInt(5, this.secuencia);
		
	
			//Regresamos un statement en vez de string
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
			String sql = "DELETE from dispositivos ;";
			stmt = con.prepareStatement(sql);			
		  
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		return stmt;
	}
	
	
	
	
}
