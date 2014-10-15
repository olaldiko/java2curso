import java.util.Scanner;


public class Principal {
	private static int numero;
	private static Scanner teclado;
	
	public static void main(String args[]){
		teclado = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		numero = teclado.nextInt();
		parImpar(numero);
	}
	
	public static void parImpar(int num){
		if(num%2 == 0){
			System.out.println("El numero es par"); 
		}else{
			System.out.println("Ël numero es impar");
		}
	}
}
