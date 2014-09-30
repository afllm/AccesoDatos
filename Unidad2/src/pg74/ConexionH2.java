/**
*Alejandro Llamas Martinez
*/

package pg74;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionH2 {

	public static void main(String[] args) {
		try {
			   Class.forName("org.h2.Driver");//2
			   Connection conexion = DriverManager.getConnection// 4
			   ("jdbc:h2:C:\\sqlite\\ejemplo\\ejemplo","sa","");//3
			   Statement sentencia = conexion. createStatement();//5
			   ResultSet result = sentencia.executeQuery("SELECT * FROM empleados");//6
			   while (result.next())//7
			     {System.out.println(result.getInt(1) + " " + result.getString(2) + " " +result.getString(3));}
			   result.close();//8
			   sentencia.close();//9
			   conexion.close();//10
			   }
			   catch (ClassNotFoundException cn) {cn.printStackTrace();}
			   catch (SQLException e) {e.printStackTrace();}

	}
	/*
	 *Alejandro llamas
	 */
}
