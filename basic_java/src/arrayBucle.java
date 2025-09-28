package llenadoarray_y_busquedafor;
import java.util.Scanner;
public class LlenadoArray_y_BusquedaFor {
	public static void main (String args[]) {
		Scanner scan = new Scanner (System.in);
		int v[];
		v = new int[5];
		int i=5, nb=0;
		i--;
//		int v[] = new int[7];
		
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
		scan.close();
		
// Búsqueda de un número pero con ford:
		
		System.out.print("Introduzca el número que desee buscar: ");
		nb=scan.nextInt();
		i=0;
			for(i=0;i<5;++i) {
				if(v[i]==nb) {
					i=5;
					System.out.println("Valor de salida del array es de: "+i);
				}
			}
			if(nb==v[i]) {
				System.out.println("El número especificado si existe dentro del array.");
			}
			else {
				System.out.println("El número especificado no existe en el array. ");
			}
		scan.close();
	}
}
