// ENUNCIADO: Llenado de una tabla de 6x4.

package llenartabla_i_j;

import java.util.Scanner;

public class LlenarTabla_i_j {
	public static void main (String args[]) {
//		Scanner scan = new Scanner (System.in);
//		int alm[][]=new int[6][4], i=0, j=0;
//		for(i=0;i<6;i++) {
//			for(j=0;j<4;j++) {
//				System.out.print("Teclee un valor para la fila "+i+" y columna "+j+": ");
//				alm[i][j] = scan.nextInt();
//			}
//		}
//		System.out.println("\n\n");
//		
//		for(i=0;i<6;i++) {
//			for(j=0;j<4;j++) {
//				System.out.print(alm[i][j]+"\t");
//			}
//		System.out.println("\n");
//		}
//		scan.close();
//	}
//}

//**********definiendo la matriz ya con los numeros en la variable**********//
		
		Scanner scan = new Scanner (System.in);
		int alm[][]= {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},};			
				
		int i=0, j=0;
		for(i=0;i<6;i++) {
			for(j=0;j<4;j++) {
				System.out.print("Teclee un valor para la fila "+i+" y columna "+j+": ");
				alm[i][j] = scan.nextInt();
			}
		}
		System.out.println("\n\n");
		
		for(i=0;i<6;i++) {
			for(j=0;j<4;j++) {
				System.out.print(alm[i][j]+"\t");
			}
		System.out.println("\n");
		}
		scan.close();
	}
}
