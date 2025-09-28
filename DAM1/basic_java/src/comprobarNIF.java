package comprobarnifmetodo;

import java.util.Scanner;

public class ComprobarNIF_Metodo {
	static char letraNIF(int n) {
		String letra = "TRWAGMYFPDXBNJZSQVHLCKE";
		return letra.charAt(n%23);
	}
	
	static boolean comprobarLetra (int n, char l) {
		return letraNIF(n)==l;		
	}

	static String teclearNIF (Scanner e) {		
		int longitud = 0;
		String dni=""; // String dni = null;
		do {		
			System.out.print("Intorduzca dni: ");
			dni = e.nextLine();
			longitud = dni.length();			
			
			if (longitud!=9) 
				System.out.print("Documentación no válida"+"\n\n");			
		}while (longitud != 9);
		return dni;	
	}
	
	static int obtenerNumero(String n) {
		int numero = 0;
		try {
			numero = Integer.parseInt (n.substring(0,8));
		}catch (NumberFormatException nfe){
			System.out.println("Error en formato NIF (numero)");
			numero = -1;
			}
		return numero;
	}
	
	static char obtenerLetra (String n) {
		char letra = Character.toUpperCase(n.substring(8).charAt(0));//el charAt devuelve el coso en caracter
		if (!Character.isLetter(letra)) {
			System.out.print("Error en formato NIF (letra)");
			letra = '*';
		}
		return letra;
	}
	
	public static void main (String args[]) {
		Scanner entrada = new Scanner (System.in);
		String dni = null;
		int numero = 0;
		char letra= ' ';
		
		do {			
			dni = teclearNIF(entrada);
			numero = obtenerNumero(dni);
			letra = obtenerLetra(dni);
			if (numero == -1 || letra == '*')
				System.out.print("\nNo es un formato válido\n");
		} while (numero == -1 || letra == '*');
		
		if (!comprobarLetra(numero,letra)) 
			System.out.println("\nNIF incorrecto\n");
		else
			System.out.println("\nNIF correcto\n");
		System.out.print("\nPrograma finalizado");
	
			
	entrada.close();
	}
}
