/// ENUNCIADO: Realizar un programa que reste dos números y los ordene adecuadamente según sea necesario para la operación de resta.
package ordenacionnumeroresta;
import java.util.Scanner; // IMPORTANTE: SIEMPRE QUE SE USE LA FUNCIÓN SCANNER, AÑADIR ESTA LÍNEA DEBAJO DEL PAQUETE.
public class OrdenacionNumerosResta {
		public static void main(String[]args) { // Línea base empleada al comienzo de cada programa, absolutamente necesaria.
			int n1=0, n2=0, dif=0; // Línea en la que se definen los valores que se emplearan en la función.
			Scanner scan=new Scanner(System.in); // Línea con la que se definirá el nombre mediante el que se empleará la función scanner a lo largo del programa.
			System.out.print("Introduzca el primer número para realizar la operación: "); // Línea mediante la que, a través de la pantalla, se presenta un texto al usuario con los pasos a seguir.
			n1=scan.nextInt(); // Línea por la que se escaneará el valor que proporcione el usuario 
			System.out.print("Introduzca el segundo número para realizar la operación: ");
			n2=scan.nextInt();
			if(n1>=n2) { // Líneas en la que se presentan varios cursos de acciones según el resultado de la condición en su interior,
				dif=n1-n2;
			}
			else {
				dif=n2-n1;
			}
			System.out.println("El resultado de su operación es: "+dif+".");
			scan.close(); // Cierre de la función scan. Importante no dejarla abierta.
			System.out.print("Programa finalizado.");
		}
	}
