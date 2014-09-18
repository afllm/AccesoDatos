package ejemplos;

import java.io.*;


public class CrearDir {
	File d,f1,f2,f3;
	
	public CrearDir(){
		d=new File("NUEVODIR");//Se crea un dir a partir del actual.
		f1=new File(d,"Fichero1.txt");
		f2=new File(d,"Fichero2.txt");
	}
	
	public void CrearDirYFich(){
		
		d.mkdir();
		try{
			if(f1.createNewFile()){
				System.out.println("Fichero1 creado correctamente...");
			}else{
				System.out.println("No se hapodido crear Fichero1...");
			}
			if(f2.createNewFile()){
				System.out.println("Fichero2 creado correctamente...");
			}else{
				System.out.println("No se hapodido crear Fichero2...");
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
			System.out.println("1 y 2 mal");
		}
		
		
	}
	public void RenombrarYCrear(){
		
		f1.renameTo(new File(d,"Fichero1Nuevo"));//Renombra Fichero1
		try{
			f3=new File("NUEVODIR/Fichero3.txt");
			f3.createNewFile();//Crea fichero3 en NUEVODIR.
		}catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	public void borrar(){
		if(f2.delete()){
			System.out.println("Fichero borrado...");
		}else{
			System.out.println("No se ha podido borrar el fichero...");
		}
	}

	public static void main(String[] args) {
		CrearDir cd=new CrearDir();
		//cd.CrearDirYFich();
		//cd.RenombrarYCrear();
		cd.borrar();

	}

}
