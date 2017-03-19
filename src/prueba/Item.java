package prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Item implements Queryable {
	
	private String tabla = "items";
	
	private float precio;
	private String item;
	private String descripcion;
	private int stock;
	private String iva;
	private String marca;
	
	private float precio2;
	private float precio3;
	private float precio4;
	private String promocion;
	private float costo;
	private String presentacion;
	private String bodega;
	
	//Setters y getters generados automaticamente
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getIva() {
		return iva;
	}
	public void setIva(String iva) {
		this.iva = iva;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public float getPrecio2() {
		return precio2;
	}
	public void setPrecio2(float precio2) {
		this.precio2 = precio2;
	}
	public float getPrecio3() {
		return precio3;
	}
	public void setPrecio3(float precio3) {
		this.precio3 = precio3;
	}
	public float getPrecio4() {
		return precio4;
	}
	public void setPrecio4(float precio4) {
		this.precio4 = precio4;
	}
	public String getPromocion() {
		return promocion;
	}
	@Override
	public String toString() {
		return "Item [precio=" + precio + ", item=" + item + ", descripcion=" + descripcion + ", stock=" + stock
				+ ", iva=" + iva + ", marca=" + marca + ", descuento=" + ", precio2=" + precio2
				+ ", precio3=" + precio3 + ", precio4=" + precio4 + ", promocion=" + promocion + ", costo=" + costo
				+ ", presentacion=" + presentacion + ", bodega=" + bodega + "]";
	}
	public void setPromocion(String promocion) {
		this.promocion = promocion;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public String getBodega() {
		return bodega;
	}
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	
	
	
	
	// Implementacion de la interfaz. Primera implentacion
	@Override
	public Object toQuery(String dbType, Connection con) {
	
		
		String query = null;   		//Creamos string query
		
		if(dbType.equals("sqlite")){
			
			query = "INSERT INTO items (precio,item,descripcion, stock, iva, marca, precio2, precio3, precio4, promocion, costo, presentacion, bodega)" + "VALUES (" + this.precio + ",'" + this.item + "','" + this.descripcion + "'," + this.stock + ",'" + this.iva + "','" + this.marca + "'," + this.precio2 + "," + this.precio3 + ","+ this.precio4 + ",'" + this.promocion + "',"+ this.costo + ",'"+ this.presentacion + "','" + this.bodega + "');";
			
			//Aqui query queda con todo el codigo de insercion
		}
			
		return query;
	}
	@Override
	public Object beforeInsert(String dbType, Connection con) {
		
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE from items ;";
			stmt = con.prepareStatement(sql);			
		  
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		return stmt;
	}
	
	
	
	
	
	

}
