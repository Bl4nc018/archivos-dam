package crearvisualizarcadena;
import java.util.Scanner;
public class CrearVisualizarCadena {
	public static void main(String[]args) {
		Scanner scan = new Scanner (System.in);
		String frase ="", frase1="";
		char vcadena[], vcadena1[];
		int i = 0, longitud=0;
		System.out.print("Teclear cadena?");
		frase=scan.nextLine();
		scan.close();
		longitud=frase.length();
		vcadena=new char[longitud];
		for(i=0; i<longitud;i++) {
			vcadena[i]= frase.charAt(i);
		}
		System.out.println("\nVisualizar vcadena: ");
		for(i=0;i<longitud;i++) {
			System.out.println(vcadena[i]);
		}
		vcadena1=frase.toCharArray();
		System.out.println("\nVisualizar cadena1: ");
		for(i=0;i<longitud; i++) {
			System.out.println(vcadena1[i]);
		}
		frase1= String.valueOf(vcadena1);
		System.out.println("Cadena1= "+frase1);
		
	}
}
