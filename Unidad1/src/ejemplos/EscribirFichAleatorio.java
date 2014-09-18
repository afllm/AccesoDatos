package ejemplos;

import java.io.*;

public class EscribirFichAleatorio {
	
	public void escribir() throws FileNotFoundException,IOException{
		File f=new File("AleatorioEmple.dat");
		//Declara el fichero de acceso aleatorio:
		RandomAccessFile raf=new RandomAccessFile(f, "rw");
		//Arrays con los datos:
		String apellido[]={"Llamas","Martinez","Lopez","Herreros"};
		int departamento[]={10,20,10,30};
		Double salario[]={1000.45,2400.60,3000.0,1500.56};
		
		StringBuffer b=null;//Buffer para almacenar el apellido.
		int n=apellido.length;//Numero de elementos del array.
				
		for(int i=0;i<n;i++){//Recorre los arrays.
			raf.writeInt(i+1);//Se usa i+1 para identificar al empleado.
			b=new StringBuffer(apellido[i]);
			b.setLength(10);//10 caracteres para el apelido.
			raf.writeChars(b.toString());//Inserta apellido.
			raf.writeInt(departamento[i]);//Inserta departamento.
			raf.writeDouble(salario[i]);//Inserta salario.
		}
		raf.close();//Cierra fichero.
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		EscribirFichAleatorio eal= new EscribirFichAleatorio();
		eal.escribir();
	}

}
