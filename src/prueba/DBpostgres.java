package prueba;

import java.sql.*;
import java.util.ArrayList;

public class DBpostgres{
	
	private Connection co = null;
	
	
	
	public  DBpostgres(){
		
		try {
		      Class.forName("org.postgresql.Driver");
		      co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres", "SebasBrito01");
		      co.setAutoCommit(false);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      throw new RuntimeException("Error al abrir SQlite DB");
		      
		    }
		    System.out.println("Conectado a Postgres DB");
		    
	}
	
	
	
//Funcion getItems	
	
public ArrayList<Queryable> getItemsTable(){
		
		ArrayList<Queryable> items = new ArrayList<Queryable>();   // Se crea un arraylist
	
		try {
			Statement stm = co.createStatement();
			ResultSet rs = stm.executeQuery( "SELECT * FROM apps.items" );
			//Leemos de postgres
			
			while(rs.next())
			{
				Item x = new Item();  //Se crea un objeto item
				
				float precio = rs.getFloat("precio");
				x.setPrecio(precio);
				
				String item = rs.getString("item");
				x.setItem(item);
				
				String descripcion = rs.getString("descripcion");
				x.setDescripcion(descripcion);
			
				int stock = rs.getInt("stock");
				x.setStock(stock);
				
				String iva = rs.getString("iva");
				x.setIva(iva);
				
				String marca = rs.getString("marca");
				x.setMarca(marca);
				
				float precio2= rs.getFloat("precio2");
				x.setPrecio2(precio2);
				
				float precio3= rs.getFloat("precio3");
				x.setPrecio3(precio3);
				
				float precio4 = rs.getFloat("precio4");
				x.setPrecio4(precio4);
				
				String promocion = rs.getString("promocion");
				x.setPromocion(promocion);
				
				float costo = rs.getFloat("costo");
				x.setCosto(costo);
				
				String presentacion = rs.getString("presentacion");
				x.setPresentacion(presentacion);
				
				String bodega = rs.getString("bodega");
				x.setBodega(bodega);
		
					
				
				items.add(x);	 // Añadimos cada objeto item al arraylist
				
			}
			
			stm.close();
			
			return  items;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return null;
		
		
	}



public ArrayList<Queryable> getVendedoresTable(){
	
	ArrayList<Queryable> vendedores = new ArrayList<>();

	try {
		Statement stm = co.createStatement();
		ResultSet rs = stm.executeQuery( "SELECT * FROM apps.vendedores" );
		
		
		while(rs.next())
		{
			Vendedor x = new Vendedor();
			
			String cedula = rs.getString("cedula");
			x.setCedula(cedula);
		
			String password = rs.getString("password");
			x.setPassword(password);
			
			String nombre = rs.getString("nombre");
			x.setNombre(nombre);
			
			String codigo = rs.getString("codigo");
			x.setCodigo(codigo);
			
			String email = rs.getString("email");
			x.setEmail(email);
			
			String tipo = rs.getString("tipo");
			x.setTipo(tipo);
			
			String ver_costos = rs.getString("ver_costos");
			x.setVer_costos(ver_costos);
			
			String supervisor = rs.getString("supervisor");
			x.setSupervisor(supervisor);
			
			String provincia = rs.getString("provincia");
			x.setProvincia(provincia);
			
			String sincronizar_desde = rs.getString("sincronizar_desde");
			x.setSincronizar_desde(sincronizar_desde);
			
			String sincronizar_hasta = rs.getString("sincronizar_hasta");
			x.setSincronizar_hasta(sincronizar_hasta);
			
			String supervisado_por = rs.getString("supervisado_por");
			x.setSupervisado_por(supervisado_por);
			
			String forzar_geolocalizacion = rs.getString("forzar_geolocalizacion");
			x.setForzar_geolocalizacion(forzar_geolocalizacion);
		
			
			
			vendedores.add(x);	
			
		}
		
		stm.close();
		
		return vendedores;
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	return null;
	
	
}



public ArrayList<Queryable> getPresupuestoVendedoresTable(){
	
	ArrayList<Queryable> presupuesto_vendedores = new ArrayList<>();

	try {
		Statement stm = co.createStatement();
		ResultSet rs = stm.executeQuery( "SELECT * FROM apps.presupuesto_vendedores" );
		
		
		while(rs.next())
		{
			PresupuestoVendedor x = new PresupuestoVendedor();
			
			String vendedor = rs.getString("vendedor");
			x.setVendedor(vendedor);
		
			String grupo = rs.getString("grupo");
			x.setGrupo(grupo);
			
			String desde = rs.getString("desde");
			x.setDesde(desde);
			
			String hasta = rs.getString("hasta");
			x.setHasta(hasta);
			
			Double presupuesto = rs.getDouble("presupuesto");
			x.setPresupuesto(presupuesto);
			
			Double ventas = rs.getDouble("ventas");
			x.setVentas(ventas);
			

			
			presupuesto_vendedores.add(x);	
			
		}
		
		stm.close();
		
		return presupuesto_vendedores;
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	return null;
	
	
}


public ArrayList<Queryable> getDispositivos(){
	
	ArrayList<Queryable> dispositivos = new ArrayList<>();

	try {
		Statement stm = co.createStatement();
		ResultSet rs = stm.executeQuery( "SELECT * FROM apps.imei_dispositivos" );
		
		
		while(rs.next())
		{
			Dispositivo x = new Dispositivo();
			
			String codigo_vendedor = rs.getString("codigo_vendedor");
			x.setCodigo_vendedor(codigo_vendedor);
		
			String imei = rs.getString("imei");
			x.setImei(imei);
			
			String activado = rs.getString("activado");
			x.setActivado(activado);
			
			String prefijo = rs.getString("prefijo");
			x.setPrefijo(prefijo);
			
			int secuencia = rs.getInt("secuencia");
			x.setSecuencia(secuencia);
			
			
			dispositivos.add(x);	
			
		}
		
		stm.close();
		
		return dispositivos;
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	return null;
}

public ArrayList<Queryable> getMensajes(){
	
	ArrayList<Queryable> mensajes = new ArrayList<>();

	try {
		Statement stm = co.createStatement();
		ResultSet rs = stm.executeQuery( "SELECT * FROM apps.mensajes" );
		
		
		while(rs.next())
		{
			Mensaje x = new Mensaje();
			
			int codigo = rs.getInt("codigo");
			x.setCodigo(codigo);
		
			String mensaje = rs.getString("mensaje");
			x.setMensaje(mensaje);
			
			
			mensajes.add(x);	
			
		}
		
		stm.close();
		
		return mensajes;
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	return null;
}
	


public ArrayList<Queryable> getClientes(){
	
	ArrayList<Queryable> clientes = new ArrayList<>();

	try {
		Statement stm = co.createStatement();
		ResultSet rs = stm.executeQuery( "SELECT * FROM apps.clientes" );
		
		
		while(rs.next())
		{
			Cliente x = new Cliente();
			
			String codigo = rs.getString("codigo");
			x.setCodigo(codigo);
		
			String nombre = rs.getString("nombre");
			x.setNombre(nombre);
			
			String direccion = rs.getString("direccion");
			x.setDireccion(direccion);
			
			String telefono1 = rs.getString("telefono1");
			x.setTelefono1(telefono1);
			
			String ciudad = rs.getString("ciudad");
			x.setCiudad(ciudad);
			
			Double monto = rs.getDouble("monto");
			x.setMonto(monto);
			
			Double saldo = rs.getDouble("saldo");
			x.setSaldo(saldo);
			
			String tipo_precio = rs.getString("tipo_precio");
			x.setTipo_precio(tipo_precio);
			
			String tipo_credito = rs.getString("tipo_credito");
			x.setTipo_credito(tipo_credito);
			
			String email = rs.getString("email");
			x.setEmail(email);
			
			int dias_credito = rs.getInt("dias_credito");
			x.setDias_credito(dias_credito);
			
			String ruc = rs.getString("ruc");
			x.setRuc(ruc);
			
			String vendedor1 = rs.getString("vendedor1");
			x.setVendedor1(vendedor1);
			
			String vendedor2 = rs.getString("vendedor2");
			x.setVendedor2(vendedor2);
			
			String representante = rs.getString("representante");
			x.setRepresentante(representante);
			
			
			clientes.add(x);	
			
		}
		
		stm.close();
		
		return clientes;
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	return null;
}


public ArrayList<Queryable> getGrupos(){
	
	ArrayList<Queryable> grupos = new ArrayList<>();

	try {
		Statement stm = co.createStatement();
		ResultSet rs = stm.executeQuery( "SELECT * FROM apps.grupos" );
		
		
		while(rs.next())
		{
			Grupo x = new Grupo();
			
			String codigo = rs.getString("codigo");
			x.setCodigo(codigo);
		
			String descripcion = rs.getString("descripcion");
			x.setDescripcion(descripcion);
			
			
			grupos.add(x);	
			
		}
		
		stm.close();
		
		return grupos;
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	return null;
}
	
		

	
}
	
	
	
	
	
	
	
