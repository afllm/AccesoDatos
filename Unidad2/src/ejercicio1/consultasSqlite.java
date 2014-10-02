package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class consultasSqlite {
	
	private String consulta;
	
	
	
	/*
	 * Metodo para selecionar consulta:
	 * */
	public void seleccionConsulta(){
		
		int seleccion;
		Scanner scn=new Scanner(System.in);
		//solicita elegir:
		System.out.println("1 - Listado empleados de Catarroja que trabajan en el departamento nª20");
		System.out.println("2 - Listado de empleados que cobran menos de 850 € y no son de Silla");
		System.out.println("3 - Salario medio de los empleados de cada localidad");
		System.out.println("4 - Listado de empleados que trabajan en Madrid o en Barcelona");
		System.out.println("5 - Listado de empleados que trabajan en Sevilla y no son de Catarroja");
		System.out.println("6 - Calcular cuantos empleados trabajan en cada departamento así como su salario medio");
		System.out.println();
		System.out.println("Por favor, selecinar una opción del 1 al 6:");
		System.out.println();
		seleccion=scn.nextInt();
		scn.close();
		
		//Se asigna la consulta según la eleccion:
		
		switch(seleccion){
		
			case 1: 
				consulta="SELECT * FROM empleados where localidad=\"Catarroja\" and depto=20;";
				break;
			case 2: 
				consulta="SELECT * FROM empleados where localidad !=\"Silla\" and salario<850;";
				break;
			case 3: 
				consulta="SELECT localidad,AVG(salario) AS SalarioMedio FROM empleados GROUP BY localidad;";
				break;
			case 4: 
				consulta="SELECT empleados.*, departamentos.loc FROM empleados INNER JOIN departamentos on empleados.depto=departamentos.dept_no where departamentos.loc IN (\"Madrid\",\"Barcelona\");";
				break;
			case 5: 
				consulta="SELECT empleados.*, departamentos.loc FROM empleados INNER JOIN departamentos on empleados.depto=departamentos.dept_no where departamentos.loc LIKE \"Sevilla\" AND empleados.localidad NOT LIKE \"Catarroja\";";
				break;
			case 6: 
				consulta="SELECT depto,SUM(depto) AS empleados,AVG(salario) AS SalarioMedio FROM empleados GROUP BY depto;";
				break;
		
		
		}
	}
	
	public void ConsultaBBDD(){
		 try {
			   Class.forName("org.sqlite.JDBC");
			   Connection conexion = DriverManager.getConnection
			   ("jdbc:sqlite:C:\\db\\sqlite\\ejemplo.db");
			   Statement sentencia = conexion. createStatement();
			   ResultSet result = sentencia.executeQuery(this.consulta);
			   while (result.next()){
				   System.out.println(result.getInt(1) + " " + result.getString(2) + " " +result.getString(3)+ " " +result.getString(4)+ " " +result.getString(5)+ " " +result.getString(6));
			   }
			   result.close();
			   sentencia.close();
			   conexion.close();
			   }
			   catch (ClassNotFoundException cn) {cn.printStackTrace();}
			   catch (SQLException e) {e.printStackTrace();}
		
	}

	public static void main(String[] args) {
		consultasSqlite csql=new consultasSqlite();
		csql.seleccionConsulta();
		csql.ConsultaBBDD();
			 
			

	}
	/*
	 *Alejandro llamas
	 */
}
