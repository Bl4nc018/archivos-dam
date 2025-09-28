// ENUNCIADO: Llene todo un array de 12 valores con números que no se dupliquen.

package llenartablavaloresunicos;
import java.util.Scanner;
public class LlenarTablaValoresUnicos {
	public static void main (String args[]) {
		Scanner scan = new Scanner (System.in);
		int n[]=new int[12], i1=0, i2=0, sw=0, aux=0;
		for(i1=0;i1<12;++i1) {
			do {
				sw=0;
				System.out.print("Teclee un valor que añadir/o con el que sustituír a otro en la matriz: ");
				n[i1] = scan.nextInt();
				for(i2=0;i2<i1 && sw==0;i2++) {
					if (n[i1]==n[i2]) {
						System.out.println("El valor tecleado ya se encuentra en la matriz, inténtelo con uno diferente. ");
						sw=1;
					}
				}
			}while(sw==1);
		}
		for(i1=0;i1<12;++i1) {
			for(i2=i1+1;i2<12;i2=i2+1) {
				if (n[i1]>n[i2]) {
					aux=n[i1];
					n[i1]=n[i2];
					n[i2]=aux;
				}			
			}
		}
		System.out.print("Esta sería la matriz ya terminada: ");
		for(i1=0;i1<12;++i1) {
			System.out.print(n[i1]+"\t");
		}
	}
}
