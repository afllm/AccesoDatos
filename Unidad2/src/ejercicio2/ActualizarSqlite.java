/**
*Alejandro Llamas Martinez
*/

package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActualizarSqlite {
	
	public void modificacionBBDD() throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
	   Connection conexion = DriverManager.getConnection
	   ("jdbc:sqlite:C:\\db\\sqlite\\ejemplo.db");
	   Statement sentencia = conexion. createStatement();
	   //Listar tabla original:
	   System.out.println("Tabla original:");
  		System.out.println();
	   ResultSet resultC = sentencia.executeQuery("SELECT * FROM empleados");
	   while (resultC.next()){
		   		
			   System.out.println(resultC.getInt(1) + " " + resultC.getString(2) + " " +resultC.getString(3)+ " " +resultC.getString(4)+ " " +resultC.getString(5)+ " " +resultC.getString(6));
		  
	   }
	   //1 - Insertar los siguientes empleados en la tabla empleados:
	   ResultSet resultS = sentencia.executeQuery("INSERT INTO empleados VALUES"+
	   "(10,'Pepito','05/09/2014',Albal,700,10),"+
	   "(11,'Anita','07/02/2014','Silla',850,20),"+
	   "(12,'Juanito','06/08/2014','Catarroja',750,30);");
	   
	   //2 - Eliminar los siguientes empleados de la tabla empleados:
	   ResultSet resultD=sentencia.executeQuery("DELETE * FROM empleados where emp_no=4 OR emp_no=5 OR emp_no=6;");
	   
	   //3 - Actualizar los datos de la tabla empleados:
	   ResultSet resultU=sentencia.executeQuery("UPDATE empleados SET salario=salario+15 WHERE localidad LIKE 'Albal';");
	   ResultSet resultU2=sentencia.executeQuery("UPDATE empleados SET salario=salario-1 WHERE(SELECT empleados.* FROM empleados INNER JOIN departamentos ON empleados.depto=departamentos.dept_no LIKE 'Sevilla';");
	   
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 *Alejandro llamas
	 */
}
