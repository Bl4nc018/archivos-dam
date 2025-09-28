package comprobarcaracter_numero;

import java.io.IOException;

public class ComprobarCaracter_Numero {
	public static void main(String[]args) {
		char caracter=' ';
		System.out.print("Teclee el caracter deseado: ");
		try {
			caracter = (char) System.in.read();
		}catch(IOException ioe) {}
		if(Character.isDigit(caracter)) 
			System.out.print("\n Se tecleó un número.");
		else 
			System.out.print("\n No tecleó un número.");
		
		if(Character.isLetter(caracter))
			System.out.print("\n Se tecleó una letra.");
		else
				System.out.print("\n No se tecleó una letra.");
		
		if(Character.isLetterOrDigit(caracter)) 
			System.out.print("\n No se tecleó un carácter alfanumérico.");
		else 
				System.out.print("\n Se tecleó un carácter alfanumérico.");
	
	}
}
