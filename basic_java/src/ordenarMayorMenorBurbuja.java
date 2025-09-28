package ordenarmayoramenorburbuja;
import java.util.Scanner;
public class OrdenarMayorAMenorBurbuja {
	public static void main(String[]args) {
		int n1=0, n2=0, n3=0, aux=0;
		Scanner scan=new Scanner(System.in);
		System.out.print("Introduzca el primer número para realizar la operación: ");
		n1=scan.nextInt();
		System.out.print("Introduzca el segundo número para realizar la operación: ");
		n2=scan.nextInt();
		System.out.print("Introduzca el tercer número para realizar la operación: ");
		n3=scan.nextInt();

		if (n1>n2) {
			aux=n1;
			n2=n1;
			n2=aux;
		}
		else {
			if(n1>n3) {
				aux=n1;
				n1=n3;
				n3=aux;
			}
			else {
				if(n2>n3) {
					aux=n2;
					n2=n3;
					n3=aux;
				}
			}
		}
		System.out.print(n1+","+n2+","+n3);
		scan.close();
	}
}
