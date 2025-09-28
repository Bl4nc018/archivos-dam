package adivinarletranif;
import java.util.Scanner;
public class AdivinarLetraNIF {
	public static void main(String[]args) {
		Scanner scan=new Scanner(System.in);
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
//		char letras[]= {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		int numero=0;
		System.out.print("Teclee número.......: ");
		numero=scan.nextInt();
//		System.out.print("Nif completo........: "+numero+letras[numero%23]);
		System.out.print("Nif completo........: "+numero+letras.charAt(numero%23));
		scan.close();
	}
}
