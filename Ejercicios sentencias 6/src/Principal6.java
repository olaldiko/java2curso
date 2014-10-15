import java.util.Scanner;


public class Principal6 {
	int[] numeros;
	int media;
	Scanner teclado;
	
	public void leeNum(int cant){
		numeros = new int[cant];
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce "+ cant +"numeros:");
		for(int i = 0;i < numeros.length;i++){
			numeros[i] = teclado.nextInt(); teclado.nextLine();
		}
	}
	
	public static int calcMedia(int[] numeros){
		int med = 0;
		for(int i = 0;i <numeros.length;i++){
			med += numeros[i];
		}
		med = med/numeros.length;
		return med;
	}
	

	public static void main(String[] args) {
		Principal6 principal = new Principal6();
		principal.leeNum(10);
		principal.media = calcMedia(principal.numeros);
		System.out.println("La media de los numeros introducidos es: "+principal.media);
		
	}

}
