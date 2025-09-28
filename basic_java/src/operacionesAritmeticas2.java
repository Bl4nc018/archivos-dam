// ENUNCIADO: Misma operación a llevar a cabo, pero esta vez usando la función do{ }while();

package ordenacionnumerosresta_dowhile;
import java.util.Scanner;
public class OrdenacionNumerosResta_DoWhile {
	public static void main(String[]args) { 
		Scanner scan=new Scanner(System.in);
		int n1=0, n2=0, dif=0;
		do {	// Esta línea abre el que será el comienzo de acciones que se repetirán hasta que la condición final sea cumplida debidamente.
			System.out.print("Introduzca el primer número para realizar la operación: ");
			n1=scan.nextInt();
			System.out.print("Introduzca el segundo número para realizar la operación: ");
			n2=scan.nextInt();
		}while(n1>n2);
		dif=n2-n1;
		System.out.print("El resultado de la operación es: "+dif);
		scan.close();
		}
	}
