package prueba;

import java.util.ArrayList;

public class DBConvertion {
	
	
	public static void main(String[] args) {
		
		
				
		DBpostgres DBmain = new DBpostgres();  // Coneccion a Postgres
	
		// Coneccion a Sqlite 1
		
		DBsqlite DB1 = new DBsqlite("sqlite", "C:\\Users\\Sebastian\\Desktop\\MyProjects\\", "datos_ar.db", "org.sqlite.JDBC"); 
		
		//Coneccion a Sqlite 2
		
		DBsqlite DB2 = new DBsqlite("sqlite", "C:\\Users\\Sebastian\\Desktop\\MyProjects\\", "vendedores_ar.db", "org.sqlite.JDBC");
				
		
		ArrayList<Queryable> presupuesto_vendedores = DBmain.getPresupuestoVendedoresTable(); //Se extrae de postgres
		DB1.Insert(presupuesto_vendedores);			                   // Insertamos en sqlite
		
		ArrayList<Queryable> dispositivos = DBmain.getDispositivos();
		DB1.Insert(dispositivos);
		
		ArrayList<Queryable> mensajes = DBmain.getMensajes();
		DB1.Insert(mensajes);
		
		ArrayList<Queryable> items =  DBmain.getItemsTable(); 
		DB1.Insert(items);     				               
		
		ArrayList<Queryable> clientes = DBmain.getClientes();
	    DB1.Insert(clientes);
		
		ArrayList<Queryable> grupos = DBmain.getGrupos();
		DB1.Insert(grupos);
		
		
		DB1.close();
		DB1.vacuum("sqlite", "C:\\Users\\Sebastian\\Desktop\\MyProjects\\", "datos_ar.db");  // Se abre nuevamente la coneccion y se ejecuta VACUUM
			
		
		ArrayList<Queryable> vendedor = DBmain.getVendedoresTable();  // Se extrae de Postgres tabla Vendedores	
		DB2.Insert(vendedor);     							 // Insertamos vendedores en sqlite 2
		
		
		DB2.close();
		
		DB1.vacuum("sqlite", "C:\\Users\\Sebastian\\Desktop\\MyProjects\\", "vendedores_ar.db"); // Conectamos de nuevo al final para hacer VACUUM
		
				
	}
	
	
	

}
