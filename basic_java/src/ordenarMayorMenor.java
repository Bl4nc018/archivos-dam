//ENUNCIADO: Ordenación de hasta tres números de menor a mayor.
package ordenarmayoramenor;
import java.util.Scanner;
public class OrdenarMayorAMenor {
	public static void main(String[]args) {
		int n1=0, n2=0, n3=0;
		Scanner scan=new Scanner(System.in);
		System.out.print("Introduzca el primer número para realizar la operación: ");
		n1=scan.nextInt();
		System.out.print("Introduzca el segundo número para realizar la operación: ");
		n2=scan.nextInt();
		System.out.print("Introduzca el tercer número para realizar la operación: ");
		n3=scan.nextInt();
		
		if (n2>n1) {
			if (n3>n1) {
				if (n3>n2) {
					System.out.print(n1+"<"+n2+"<"+n3);
				}
				else {
					System.out.print(n1+"<"+n3+"<"+n2);
				}
			}
			else {
				System.out.print(n3+"<"+n1+"<"+n2);
				}
		}
		else {
			if (n2<n3) {
				if (n1<n3) {
					System.out.print(n2+"<"+n1+"<"+n3);
				}
				else {
					System.out.print(n2+"<"+n3+"<"+n1);
				}
			}
			else {
				System.out.print(n3+"<"+n2+"<"+n1);
			}	
		}
		scan.close();
	}
}
