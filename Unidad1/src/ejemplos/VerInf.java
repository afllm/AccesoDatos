package ejemplos;

import java.io.*;


public class VerInf {
	
	public void MostrarInfo(){
		System.out.println("Informacio sobre el fichero:");
		File f = new File("C:\\Users\\Alejandro\\workspace\\accesoDatos\\Unidad1\\src\\ejemplos","VerInf.java");
		if(f.exists()){
			System.out.println("Nombre del fichero: "+f.getName());
			System.out.println("Ruta: "+f.getPath());
			System.out.println("Ruta absoluta: "+f.getAbsolutePath());
			System.out.println("Se puede leer: "+f.canRead());
			System.out.println("Se puede escribir: "+f.canWrite());
			System.out.println("Tamaño: "+f.length());
			System.out.println("Es un directorio: "+f.isDirectory());
			System.out.println("Es un fichero: "+f.isFile());
		}else{
			System.out.println("No se encuentra el fichero");
		}
	}

	public static void main(String[] args) {
		VerInf vi=new VerInf();
		vi.MostrarInfo();
		
	}

}
