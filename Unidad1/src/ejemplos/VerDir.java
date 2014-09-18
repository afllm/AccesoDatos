package ejemplos;

import java.io.*;
import java.util.Scanner;



public class VerDir {
	
	private Scanner sc;
	private String ruta;
	boolean rutaValida=false;
	
	public void MostrarDir(){
		
		//System.out.println("Ficheros en el directorio actual:");
		//File f = new File(".");
		sc=new Scanner(System.in);
		System.out.println("Ingrese la ruta:");
		
		ruta=sc.next();
		
		System.out.println("Ficheros en la ruta \""+ruta+"\":");
		File f=new File(ruta);
		sc.close();
		String[] archivos = f.list();
		for (int i=0;i<archivos.length;i++){
			System.out.println(archivos[i]);
		}
	}

	public static void main(String[] args) {
		VerDir vd= new VerDir();
		vd.MostrarDir();

	}

}
