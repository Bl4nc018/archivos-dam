import java.util.Scanner;
public class metodo13ç {
	
	static boolean esPalindrono(String f) {
		boolean cierto =true;
		String f1 ="";
		int pos=0, l=0;
		l= f.length();
		for(pos=0; pos<l; pos++) {
			if(f.charAt(pos)!= ' ')
				f1+=f.charAt(pos);
		}
		l=(f1.length()-1);
		for(pos=0; pos<=1/2 && cierto; pos++) {
			if(Character.toLowerCase(f1.charAt(pos))!=Character.toLowerCase(f1.charAt(l-pos)))
				cierto=false;
		}
		return cierto;
	}
	
	
	public static void main(String[]args) {
		Scanner scan=new Scanner(System.in);
		String frase="";
		System.out.println("Teclee una frase...: ");
		frase=scan.nextLine();
		if(esPalindrono(frase)) {
			System.out.println("\nLa frase si es un palíndromo.");
		}else {
			System.out.println("\nLa frase no es un palíndromo.");
		}
		scan.close();
	
	}
	
}