package ejemplos;

import java.io.*;
import java.util.Scanner;


public class LeerFichAleatorio {
	
	Scanner sc;

	public void leer() throws FileNotFoundException, IOException{

		File f=new File("AleatorioEmple.dat");
		//Declara el fichero de acceso aleatorio:
		RandomAccessFile raf=new RandomAccessFile(f, "r");

		int id,dep,posicion;
		Double salario;
		char apellido[]=new char[10],aux;

		posicion=0;//Para situarse al principio.

		for(;;){//Recorre el fichero.(;;) crea un bucle infinito.
			raf.seek(posicion);//se posiciona en en posicion.
			id=raf.readInt();//Obtiene id de empleado.
			for(int i=0;i<apellido.length;i++){
				aux=raf.readChar();//Recorre uno a uno los caracteres del apellido.
				apellido[i]=aux;//Se van guardando en el array.
			}
			String apellidoS=new String(apellido);//Convierte a String el array.
			dep=raf.readInt();//Obtiene departamento.
			salario=raf.readDouble();//Obtiene salario.
			
			System.out.println("ID: "+id+", apellido: "+apellidoS+", departamento: "+dep+", salario: "+salario);
			posicion+=36;//Se posiciona para el siguiente empleado, cada empleado ocupa 36 bytes (4+20+4+8).
			//Si he recorrido todos los bytes, salgo del for infinito:
			if(raf.getFilePointer()==raf.length()){
				break;
			}
		}//Fin del bucle for infinito.
		raf.close();//Cierra el fichero.
	}
	
	public void leerUnRegistro() throws IOException{//No va bien
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

	public static void main(String[] args) throws FileNotFoundException, IOException {
		LeerFichAleatorio lfa= new LeerFichAleatorio();
		//lfa.leer();
		lfa.leerUnRegistro();
	}

}
