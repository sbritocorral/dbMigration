package prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Vendedor implements Queryable {
	
	private String tabla = "vendedores";
	
	private String cedula;
	private String password;
	private String nombre;
	private String codigo;
	private String email;
	private String tipo;
	private String ver_costos;
	private String supervisor;
	private String provincia;
	private String sincronizar_desde;
	private String sincronizar_hasta;
	private String supervisado_por;
	private String forzar_geolocalizacion;
	
	//Setters y getters automaticos
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getVer_costos() {
		return ver_costos;
	}
	public void setVer_costos(String ver_costos) {
		this.ver_costos = ver_costos;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getSincronizar_desde() {
		return sincronizar_desde;
	}
	public void setSincronizar_desde(String sincronizar_desde) {
		this.sincronizar_desde = sincronizar_desde;
	}
	public String getSincronizar_hasta() {
		return sincronizar_hasta;
	}
	public void setSincronizar_hasta(String sincronizar_hasta) {
		this.sincronizar_hasta = sincronizar_hasta;
	}
	public String getSupervisado_por() {
		return supervisado_por;
	}
	public void setSupervisado_por(String supervisado_por) {
		this.supervisado_por = supervisado_por;
	}
	public String getForzar_geolocalizacion() {
		return forzar_geolocalizacion;
	}
	public void setForzar_geolocalizacion(String forzar_geolocalizacion) {
		this.forzar_geolocalizacion = forzar_geolocalizacion;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	@Override
	public String toString() {
		return "Vendedor [cedula=" + cedula + ", password=" + password + ", nombre=" + nombre + ", codigo=" + codigo
				+ ", email=" + email + ", tipo=" + tipo + ", ver_costos=" + ver_costos + ", supervisor=" + supervisor
				+ ", provincia=" + provincia + ", sincronizar_desde=" + sincronizar_desde + ", sincronizar_hasta="
				+ sincronizar_hasta + ", supervisado_por=" + supervisado_por + ", forzar_geolocalizacion="
				+ forzar_geolocalizacion + "]";
	}
	
	
	
	//Segunda implementacion con PreparedStatements
	
	@Override
	public Object toQuery(String dbType, Connection con) {
		
		String query = null;
		
		// En esta linea el codigo no es tan largo la ultima parte comparado con items
		query = "INSERT INTO vendedores (cedula, password, nombre, codigo, email, tipo, ver_costos, supervisor, provincia, sincronizar_desde, sincronizar_hasta, supervisado_por, forzar_geolocalizacion) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, this.cedula);
			statement.setString(2, this.password);
			statement.setString(3, this.nombre);
			statement.setString(4, this.codigo);
			statement.setString(5, this.email);
			statement.setString(6, this.tipo);
			statement.setString(7, this.ver_costos);
			statement.setString(8, this.supervisor);
			statement.setString(9, this.provincia);
			statement.setString(10, this.sincronizar_desde);
			statement.setString(11, this.sincronizar_hasta);
			statement.setString(12, this.supervisado_por);
			statement.setString(13, this.forzar_geolocalizacion);
	
			//Regresamos un statement en vez de string
			return statement;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		// Asi seria el otro caso aunque la linea de query es mas larga.
		
		/*
		if(dbType.equals("sqlite")){
			
			query = "INSERT INTO vendedores (cedula, password, nombre, codigo, email, tipo, ver_costos, supervisor, provincia, sincronizar_desde, sincronizar_hasta, supervisado_por, forzar_geolocalizacion)" + "VALUES ('" + this.cedula + "','" + this.password + "','" + this.nombre + "','" + this.codigo + "','" + this.email + "','" + this.tipo + "','" + this.ver_costos + "','" + this.supervisor + "','"+ this.provincia + "','" + this.sincronizar_desde + "','"+ this.sincronizar_hasta + "','"+ this.supervisado_por + "','" + this.forzar_geolocalizacion + "');";
			
		}
		
		*/
			
		return query;

	}
	@Override
	public Object beforeInsert(String dbType, Connection con) {
		
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE from vendedores ;";
			stmt = con.prepareStatement(sql);			
		  
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return stmt;
	}
	
	
	
	
	
	
	

	
	

}
