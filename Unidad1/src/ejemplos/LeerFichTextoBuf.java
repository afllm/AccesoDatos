package ejemplos;

import java.io.*;


public class LeerFichTextoBuf {
	
	public void lecturaFicheroBuf(){
		try{
			BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Alejandro\\git\\AccesoDatos\\Unidad1\\src\\ejemplos\\LeerFichTexto.java"));
			String linea;
			while((linea=br.readLine())!=null){//Lee una linea del fichero.
				System.out.println(linea);
			}
			br.close();
		}catch(FileNotFoundException fex){
			System.out.println("No se encuentra el fichero");
		}catch(IOException iex){
			System.out.println("Error de E/S");
		}
	}

	public static void main(String[] args) {
		LeerFichTextoBuf lfb= new LeerFichTextoBuf();
		lfb.lecturaFicheroBuf();

	}

}
