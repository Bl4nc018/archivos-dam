package rellenararray_y_buscar;
import java.util.Scanner;
public class RellenarArray_y_Buscar {
	public static void main (String args[]) {
		Scanner scan = new Scanner (System.in);
		int v[];
		v = new int[5]; // Línea en la que se crea un nuevo array unidimensional y en el que se determina cual será el espacio que ocupará.
		int i=5, nb=0;
		i--;
//		int v[] = new int[7]; Línea para crear el array en el mismo comando.
		while (i<5 && 0<=i) {
			System.out.print("Introduzca un valor para llenar el array: ");
			v[i] = scan.nextInt();
			i--;
			}
		System.out.println("\n");
		i=0;
		while (i>=0 && i<5) {
			System.out.print(v[i]+"\t");
			i++;	
			}
		System.out.println("\n");
		
// Búsqueda de un número:
		
		System.out.print("Introduzca el número que desee buscar: ");
		nb=scan.nextInt();
		i=0;
		while (nb!=v[i]) {
			i=i+1;
			if (i<5) {
				if (nb==v[i]) {
					System.out.println("El número especificado si existe dentro del array.");
				}
			}
			else {
				System.out.println("El número especificado no existe en el array. ");
			}
		}
		scan.close();
	}
}
