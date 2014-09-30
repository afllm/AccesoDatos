package ejemplos;

import java.io.*;


public class EscribirFichTexto {
	
	File f;
	FileWriter fw;
	
	public void escribirFichero() throws IOException{
		
		f=new File(".","FichTexto2.txt");
		fw=new FileWriter(f);//Crea el flujo de salida.
		String cadena="Esto es una prueba con FileWriter";
		char[] cad=cadena.toCharArray();//Convertir el String en array de caracteres.
		
//		for(int i=0;i<cad.length;i++){
//			fw.write(cad[i]);//Se escribe un caracter.
//		}
		fw.write(cad);//Escribe de una vez todo el array.
		fw.append("*");//Añade al final un *
		fw.close();//Cierra el fichero.
	}
	
	public void arrayDeCadenas() throws IOException{
		f=new File(".","FichTextCadenas.txt");
		fw=new FileWriter(f,true);//Crea el flujo de salida. el true hace que se escriba al final sin borrar el contenido del fichero.
		String prov[]={"Albacete ","Avila ","Madrid ","Valencia ","Sevilla "};
		for(int i=0;i<prov.length;i++){
			fw.write(prov[i]);//Escribe una cadena del array de cadenas.
		}
		fw.close();
		
	}

	public static void main(String[] args) throws IOException {
		EscribirFichTexto eft=new EscribirFichTexto();
		//eft.escribirFichero();
		eft.arrayDeCadenas();
	}

}
