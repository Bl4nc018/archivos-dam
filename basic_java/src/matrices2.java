// ENUNCIADO: Llene una matriz con números para luego proceder a desordenar el orden de estos aleatoriamente en la segunda.

package matrizaleatoria;
import java.util.Scanner;
public class MatrizAleatoria {
	public static void main (String args[]) {
		Scanner scan = new Scanner (System.in);
		int v1[]=new int [6]; 
		int v2[]=new int [6];
		int i1=0;
		
		for(i1=0;i1<6;i1=i1+2) {
			System.out.print("Teclee el número que desee introducir en la matriz: ");
			v1[i1] = scan.nextInt();
		}
		for(i1=0;i1<6;i1=i1+1) {
			if(v1[i1]==0) {
				System.out.print("Teclee el número que desee introducir en la matriz: ");
				v1[i1] = scan.nextInt();
			}
		}
		System.out.print("La primera matriz será: ");
		for(i1=0;i1<6;i1=i1+1) {
			System.out.print(v1[i1]);
		}
		
		v2[0]=v1[5];
		for(i1=0;i1<6;i1=i1+1) {
			if(v2[i1]==0) {
				v2[i1]=v1[i1-1];
			}
		}
		System.out.print("   La segunda matriz será: ");
		for(i1=0;i1<6;i1=i1+1) {
			System.out.print(v2[i1]);
		}
		scan.close();
	}
}
