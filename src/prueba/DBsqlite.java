package prueba;

import java.sql.*;
import java.util.ArrayList;

public class DBsqlite {

	private Connection co = null;
	private String dbGlobal;
	
	// Aqui el constructor. Cada que creamos un objeto se inicia la coneccion.
	
	public  DBsqlite(String dbType, String path, String db, String driver){
		this.dbGlobal = db;
		try {
		      Class.forName(driver);
		      co = DriverManager.getConnection("jdbc:" + dbType + "://" + path + db);
		      //System.out.println("jdbc:" + dbType + "://" + path + db);
		      co.setAutoCommit(false);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      throw new RuntimeException("Error al abrir SQlite DB");
		    }
		    System.out.println("Conectado a Sqlite DB de " + db);
		    
		    
		
	}
	
	
	
public void Insert(ArrayList<Queryable> querys){     //Funcion insertar query
		
		try {
			Statement stm = co.createStatement();
			
			int x = 0;
			
			for (Queryable query : querys) {
			
				
				if(x == 0)
				{
					PreparedStatement prepare = (PreparedStatement) query.beforeInsert("sqlite", co);
					prepare.executeUpdate();
					co.commit();
					x++;
				}
				
				Object temporal = query.toQuery("sqlite", co); // Se lee cada query aqui
				
				if(temporal instanceof String)				// Primera implementacion 
				{
					stm.executeUpdate((String)temporal);	// Se insertan cada query aqui
				}
				
				if(temporal instanceof PreparedStatement)   //Segunda implementacion con PreparedStatement
				{
					((PreparedStatement)(temporal)).executeUpdate(); // Se insertan en este caso tambien
				}	
				
			}
				
			
			stm.close();
			co.commit();
			//co.close();
			
			
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(querys.get(0).getTabla() + " actualizados en " + this.dbGlobal);
	}
	
	
	
	public void close(){
		try {
			co.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
