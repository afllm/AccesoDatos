/**
*Alejandro Llamas Martinez
*/

package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActualizarMysql {
	
	public void modificacionBBDD() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	   Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo","root","dam2");
	   Statement sentencia = conexion. createStatement();
	   //Listar tabla original:
	   System.out.println("Tabla original:");
  		System.out.println();
	   ResultSet resultC = sentencia.executeQuery("SELECT * FROM empleados");
	   while (resultC.next()){
		   		
			   System.out.println(resultC.getInt(1) + " " + resultC.getString(2) + " " +resultC.getString(3)+ " " +resultC.getString(4)+ " " +resultC.getString(5)+ " " +resultC.getString(6));
		  
	   }
	   //1 - Insertar los siguientes empleados en la tabla empleados:
	   int resultS = sentencia.executeUpdate("INSERT INTO empleados VALUES(10,'Pepito','05/09/2014','Albal',700,10);");
	   int resultS2 = sentencia.executeUpdate("INSERT INTO empleados VALUES(11,'Anita','07/02/2014','Silla',850,20);");
	   int resultS3 = sentencia.executeUpdate("INSERT INTO empleados VALUES(12,'Juanito','06/08/2014','Catarroja',750,30);");
	   
	   //2 - Eliminar los siguientes empleados de la tabla empleados:
	   int resultD=sentencia.executeUpdate("DELETE FROM empleados where emp_no=4 OR emp_no=5 OR emp_no=6;");
	   
	   //3 - Actualizar los datos de la tabla empleados:
	   int resultU=sentencia.executeUpdate("UPDATE empleados SET salario=salario+15 WHERE localidad LIKE 'Albal';");
	   int resultU2=sentencia.executeUpdate("UPDATE empleados SET salario=salario-1 WHERE(SELECT empleados.salario FROM empleados INNER JOIN departamentos ON empleados.depto=departamentos.dept_no LIKE 'Sevilla');");
	   
	 //Listar tabla modificada:
	   System.out.println("Tabla modificada:");
  		System.out.println();
	   ResultSet resultM = sentencia.executeQuery("SELECT * FROM empleados");
	   while (resultC.next()){
		   		
			   System.out.println(resultM.getInt(1) + " " + resultM.getString(2) + " " +resultM.getString(3)+ " " +resultM.getString(4)+ " " +resultM.getString(5)+ " " +resultM.getString(6));
		  
	   }
	   resultC.close();
	   resultM.close();
	   sentencia.close();
	   conexion.close();
	   
	}
	
	
	
	public static void main(String[] args) {
		ActualizarSqlite as= new ActualizarSqlite();
		try {
			as.modificacionBBDD();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error:");
			e.printStackTrace();
		}
	}
	/*
	 *Alejandro llamas
	 */
}
