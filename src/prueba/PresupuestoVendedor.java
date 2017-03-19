package prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PresupuestoVendedor implements Queryable {
	
	private String tabla = "presupuesto_vendedores";
	
	private String vendedor;
	private String grupo;
	private String desde;
	private String hasta;
	private double presupuesto;
	private double ventas;
	
	
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getDesde() {
		return desde;
	}
	public void setDesde(String desde) {
		this.desde = desde;
	}
	public String getHasta() {
		return hasta;
	}
	public void setHasta(String hasta) {
		this.hasta = hasta;
	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	public double getVentas() {
		return ventas;
	}
	public void setVentas(double ventas) {
		this.ventas = ventas;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	@Override
	public String toString() {
		return "PresupuestoVendedor [vendedor=" + vendedor + ", grupo=" + grupo + ", desde=" + desde + ", hasta="
				+ hasta + ", presupuesto=" + presupuesto + ", ventas=" + ventas + "]";
	}
	@Override
	public Object toQuery(String dbType, Connection con) {
		
		String query = null;
		
		// En esta linea el codigo no es tan largo la ultima parte comparado con items
		query = "INSERT INTO presupuesto_vendedores (vendedor, grupo, desde, hasta, presupuesto, ventas) values (?,?,?,?,?,?)";
		try {
			
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, this.vendedor);
			statement.setString(2, this.grupo);
			statement.setString(3, this.desde);
			statement.setString(4, this.hasta);
			statement.setDouble(5, this.presupuesto);
			statement.setDouble(6, this.ventas);
	
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
			String sql = "DELETE from presupuesto_vendedores ;";
			stmt = con.prepareStatement(sql);			
		  
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		return stmt;
	}

}
