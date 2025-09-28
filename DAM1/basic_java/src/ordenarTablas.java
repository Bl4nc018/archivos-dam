//ENUNCIADO: Llene un array, ordenelo e introduzca la función de búsqueda del número.

package ordenartabla_buscarnumero;
import java.util.Scanner;
public class OrdenarTabla_BuscarNumero {
	public static void main (String args[]) {
		Scanner scan = new Scanner (System.in);
		int n[];
		n = new int[12];
		int i1=0, i2=11, i3=0, nb=0, sw=0, aux=0;
		
		while (i1<12) {
			System.out.print("Teclee un valor que añadir a la matriz: ");
			n[i1] = scan.nextInt();
			i1++;
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
		
		System.out.println("\n");
		System.out.println("Esta sería la tabla de todos los valores correctamente ordenados: ");
		
		for(i1=0;i1<12;++i1) {
			System.out.print(n[i1]+"\t");
			}
		
		System.out.print("Teclee el valor que desee buscar en la matriz: ");
		nb=scan.nextInt();
		i1=0; i2=0;
		
		do {
			i3=(i1+i2)/2;
			if(n[i3]==0) {
				sw=1;
			}
			else {
				if(nb>n[i3]) {
					i1=i3+1;
					}
				else {
					i2=i3-1;
					}
				}
			}while(i1<=i2 && sw==0);
		
		if(sw==0) {
			System.out.println("\n El valor buscado no está en el vector.");
		}
		else{
			System.out.println("\n El valor buscado se encuentra en el vector.");
		}
		
	scan.close();
	}
}
