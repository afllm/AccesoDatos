package ejemplos;

import java.io.*;
import java.util.Scanner;



public class Actividad2 {
	
	File f;
	FileReader fr;
	Scanner sc;
	String archivoElegido;
	
	public void elegirFichero(){
		sc=new Scanner(System.in);
		System.out.println("Introducir el nombre del archivo con la extensión:");
		archivoElegido=sc.next();
		
	}
	
	public void leerFichero(){
		f=new File("C:\\Users\\Alejandro\\Desktop",archivoElegido);
		try {
			fr=new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char c[]=new char[70];
		try {
			while((fr.read(c))!=-1){
				System.out.println(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Actividad2 a=new Actividad2();
		a.elegirFichero();
		a.leerFichero();

	}

}
