// ENUNCIADO: Llenar un array de valores de manera desordenada y conseguir que este los ordene mediante el método burbuja.
package tablaordenada_desordenada;
import java.util.Scanner;
public class TablaOrdenada_Desordenada {
	public static void main (String args[]) {
		Scanner scan = new Scanner (System.in);
		int v[];
		v = new int[7];
		int i1=7, aux=0, i2=0;
		i1--;
		while (i1<7 && 0<=i1) {
			System.out.print("Introduzca un valor para llenar el array: ");
			v[i1] = scan.nextInt();
			i1--;
		}
		scan.close();
		System.out.println("\n");
		System.out.println("Esta sería la tabla de todos los valores desordenados: ");
		for(i1=0;i1<7;++i1) {
			System.out.print(v[i1]+"\t");
		}
		for(i1=0;i1<7;++i1) {
			for(i2=i1+1;i2<7;i2=i2+1) {
				if (v[i1]>v[i2]) {
					aux=v[i1];
					v[i1]=v[i2];
					v[i2]=aux;
					}			
				}
			}
		System.out.println("\n");
		System.out.println("Esta sería la tabla de todos los valores correctamente ordenados: ");
		for(i1=0;i1<7;++i1) {
			System.out.print(v[i1]+"\t");
			}
	}
	
}
