package ejemplos;

import java.io.*;
import java.util.Scanner;


public class ModificarFichAleatorio {
	
	Scanner sc;
	
	public void NuevoRegistro() throws IOException{
		File f=new File("AleatorioEmple.dat");
		//Declara el fichero de acceso aleatorio:
		RandomAccessFile raf=new RandomAccessFile(f, "r");

		int id,dep,posicion;
		Double salario;
		char apellido[]=new char[10],aux;
		sc= new Scanner(System.in);
		System.out.println("Introduzca el id de empleado: ");
		System.out.println();
		int identificador= sc.nextInt();
		System.out.println("Introduzca el apellido de empleado: ");
		System.out.println();
		
		sc.close();
		
		posicion=(identificador-1)+36;//Calcula donde empieza el registro.
		if(posicion>=raf.length()){
			System.out.println("ID: "+identificador+"; No existe el empleado");
		}else{
			raf.seek(posicion);//Se posiciona.
			id=raf.readInt();//Obtengo id de empleado.
			for(int i=0;i<apellido.length;i++){
				aux=raf.readChar();//Recorre uno a uno los caracteres del apellido.
				apellido[i]=aux;//Se van guardando en el array.
			}
			String apellidoS=new String(apellido);//Convierte a String el array.
			dep=raf.readInt();//Obtiene departamento.
			salario=raf.readDouble();//Obtiene salario.
			
			System.out.println("ID: "+id+", apellido: "+apellidoS+", departamento: "+dep+", salario: "+salario);
	
		}

		raf.close();//Cierra el fichero.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
