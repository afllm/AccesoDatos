package ejemplos;

import java.io.*;


public class LeerFichTexto{
	
	File fichero;
	FileReader fic;
	
	public LeerFichTexto(){
		
	}
	
	public void lecturaTexto(){
		
		fichero=new File("C:\\Users\\Alejandro\\git\\AccesoDatos\\Unidad1\\src\\ejemplos\\LeerFichTexto.java");
		try {
			fic=new FileReader(fichero);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Crea el flujo de entrada.
		//int i;
		char b[]=new char[20];
		try {
			while((fic.read(b))!=-1){//Se va leyendo un caracter.
				System.out.println(b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fic.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		LeerFichTexto lft=new LeerFichTexto();
		lft.lecturaTexto();

	}

}
