package sumarcaracter_y_numero;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class SumarCaracter_y_Numero {
		public static void main(String[]args) {
			Scanner e = new Scanner (System.in);
			char caracter=' ', letra=' ';
//			int caracter = 0;
			int num = 0;
			try {
				System.out.print("Teclea número?: ");
				num = e.nextInt();
			}catch(InputMismatchException ei) {
				System.out.println("Tenía que teclearse un número.");
				num=8;}
			System.out.println("\nEl número es: "+num);
//			do {
				try {
					System.out.print("Teclea caracter?: ");
					caracter = Character.toLowerCase((char)System.in.read());
					letra = Character.toLowerCase((char)System.in.read());
					while(System.in.read()!='\n');
				}catch(IOException ioe) {}
//			}while(caracter != 's' && caracter != 'n' );
//			if(caracter == 's') {
//				System.out.println("Acierto");
//			}
//			else
//				System.out.println("Fallo");
			System.out.println("\nEl caracter es: "+caracter);
			System.out.println("\n La suma de caracter + letra = "+(caracter+letra));
		e.close();
		}
// Comentarios:
// para pasar a minúsculas los carácteres => Character.toLowerCase
}
