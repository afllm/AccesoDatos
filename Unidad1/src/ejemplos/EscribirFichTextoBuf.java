package ejemplos;

import java.io.*;



public class EscribirFichTextoBuf {
	
	public void escribirFTB(){
		try{
			BufferedWriter br=new BufferedWriter(new FileWriter("FichTexto.txt", true));
			for(int i=1;i<11;i++){
				br.write("Fila numero: "+i);//Escribe una linea.
				br.newLine();//escribe un salto de linea.
			}
			br.close();
		}catch(FileNotFoundException fn){
			System.out.println("No se encuentra el archivo");
		}catch(IOException io){
			System.out.println("Error de E/S");
		}
	}
	
	public void escribirPW(){
		try{
			PrintWriter pw=new PrintWriter(new FileWriter("FichTextoPW.txt"));
			for (int i=1;i<11;i++){
				pw.println("Esta es la fila numero: "+i);
			}
			pw.close();
		}catch(FileNotFoundException fn){
			System.out.println("No se encuentra el archivo");
		}catch(IOException io){
			System.out.println("Error de E/S");
		}
	}

	public static void main(String[] args) {
		EscribirFichTextoBuf efb= new EscribirFichTextoBuf();
		//efb.escribirFTB();
		efb.escribirPW();
	}

}
