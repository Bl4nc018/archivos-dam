package adivinarletranifmetodo;
import java.util.Scanner;
public class AdivinarLetraNIF_Metodo {

	// Primer static, sirve para definir la variable local n, de número e inicializamos un scanner para obtener el número por parte del usuario.
		
		static int tecleaNumero(Scanner e) {
			int n= 0;
			System.out.print("Teclea número?: ");
			n=e.nextInt();
			return n;
		}
		
	// En este segundo static, de variable local char, se define el string de letras posibles y la manera en que hallaremos la letra correcta con la operación.
		
		static char letraNif(int n) {
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			return letras.charAt(n%23);
		}
		
	// Tercer método sirve para visualizar el Nif.
		
		static void visualizarNif(int n, char l) {
			System.out.println("Nif == "+n+l);
		}

	// Ultimo método sirve para ejecutar todo.
		
		public static void main(String[]args) {
			Scanner scan=new Scanner(System.in);
			int numero = tecleaNumero(scan);
			char letra = letraNif(numero);
			visualizarNif(numero,letra);
			scan.close();
			
		}
}
