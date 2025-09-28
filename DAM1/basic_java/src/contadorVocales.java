// ENUNCIADO: Proponer 12 letras, contar las vocales que aparecen y la cantidad de veces que se repite cada vocal.

package contadorvocales;
import java.io.IOException;
public class ContadorVocales {
	public static void main(String[]args) {
		char vc[] = new char[12];
		int i = 0, cv=0, cta=0, cte=0, cti=0, cto=0, ctu=0;
		for(i=0;i<12;i++) {
			try {
				System.out.print("Teclea el "+(i+1)+"º caracter: ");
				vc[i]=(char) System.in.read();
				while(System.in.read()!='\n');
			}catch(IOException ioe) {};
		}
		System.out.println("\n");
		
		for(i=0;i<12;i++) {
			if(Character.toLowerCase(vc[i])=='a' || Character.toLowerCase(vc[i])=='e' || Character.toLowerCase(vc[i])=='i' || Character.toLowerCase(vc[i])=='o' || Character.toLowerCase(vc[i])=='u' ) {
				cv++;
			}
		}
		
		for(i=0;i<12;i++) {
			if(Character.toLowerCase(vc[i])=='a') {
				cta++;
				}
			else {
				if(Character.toLowerCase(vc[i])=='e') {
					cte++;
					}
				else {
					if(Character.toLowerCase(vc[i])=='i') {
						cti++;
						}
					else {
						if(Character.toLowerCase(vc[i])=='o') {
							cto++;
							}
						else {
							if(Character.toLowerCase(vc[i])=='u') {
								ctu++;
								}
						}
					}
				}
			}
		}
		System.out.println("\n El número de vocales contadas es de: "+cv);
		
		System.out.println("\n Veces que aparece la a: "+cta+". Veces que aparece la e: "+cte+". Veces que aparece la o: "+cto+". Veces que aparece la i: "+cti+". Veces que aparece la u: "+ctu+".");
		
		}
	
// /***** Mismo ejercicio pero con switch *****/
	
//	public static void main(String[]args) {
//		char vc[]=new char[12];
//		int i = 0, cv=0,cta=0, cte=0, cti=0, cto=0, ctu=0, cc=0;
//		
//		for(i=0;i<12;i++) {
//			try {
//				System.out.print("Teclea el "+(i+1)+"º caracter: ");
//				vc[i]=(char) System.in.read();
//				while(System.in.read()!='\n');
//			}catch(IOException ioe) {};
//		}
//		System.out.println("\n");
//		
//		
//		for(i=0;i<12;i++) {
//			if(Character.toLowerCase(vc[i])=='a' || Character.toLowerCase(vc[i])=='e' || Character.toLowerCase(vc[i])=='i' || Character.toLowerCase(vc[i])=='o' || Character.toLowerCase(vc[i])=='u' ) {
//				cv++;
//			}
//		}
//		
//		
//		for(i=0;i<12;i++) {
//			switch(Character.toLowerCase(vc[i])) {
//			case 'a':
//				cta++;
//				break;
//			case 'e':
//				cte++;
//				break;
//			case 'i':
//				cti++;
//				break;
//			case 'o':
//				cto++;
//				break;
//			case 'u':
//				ctu++;
//				break;
//				default:
//					cc++;
//				
//			}
//		}
//		System.out.println("\n El número de letras contadas es de: "+cv);
//		
//		System.out.println("\n Veces que aparece la a: "+cta+". \n Veces que aparece la e: "+cte+". \n Veces que aparece la o: "+cto+". \n Veces que aparece la i: "+cti+". \n Veces que aparece la u: "+ctu+".");
//		
//		System.out.println("\n Veces que aparecen otros caracteres: "+cc);
//	  }
		
}
