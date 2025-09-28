package comparadorcadenasinvertirconstruir;

import java.io.IOException;
import java.util.Scanner;

public class ComparadorCadenas_Invertir_Construir {
	public static void main(String [] args) {
		Scanner scan=new Scanner(System.in);
		char letra = ' '; 
		String cadena = "", cadena2="", fc="";
		int i=0;
		System.out.print("Teclee la 1ª cadena deseada: ");
		cadena=scan.nextLine();
		System.out.print("Teclee la 2ª cadena deseada: ");
		cadena2=scan.nextLine();
		System.out.print("Teclee el valor de la posición: ");
		i=scan.nextInt();
		System.out.println("1ª Cadena: "+cadena);
		System.out.println("2ª Cadena: "+cadena2);
		System.out.println("Longitud de la cadena = "+cadena.length());
		System.out.println("Caracter 7 de la cadena = "+cadena.charAt(0));
		scan.close();
		
/**************Invirtiendo la cadena************************/
		
		System.out.print("\n Frase escrita correctamente: "+cadena);
		System.out.print("\n ");
		System.out.print("\n Frase escrita de manera inversa: ");
		for(i=(cadena.length()-1);i>=0;i--) {
			System.out.print(cadena.charAt(i));
		}

/**************Construir una frase letra por letra**********/
		try {
			do {
				System.out.print("Introduzca la letra que desee añadir. Recuerde pulsar * si quiere terminar la frase y/ o salir del programa: ");
				letra=(char) System.in.read();	
				while(System.in.read() != '\n');
					if(letra!='*') {
						fc=fc+letra;
					}
			}while(letra!='*');
		}catch(IOException ioe) {};
		System.out.print("\n Esta sería su frase terminada: "+fc);
	}
}
