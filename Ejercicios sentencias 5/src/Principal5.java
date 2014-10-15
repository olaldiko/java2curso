import java.util.Scanner;


public class Principal5 {
	Scanner teclado;
	int numeros[];
	public void leeNum(){
		numeros = new int[10];
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce diez numeros:");
		for(int i = 0;i <10;i++){
			numeros[i] = teclado.nextInt(); teclado.nextLine();
		}
	}
	public void numInv(){
		System.out.println("Estos son los numeros en orden inverso: ");
		for(int i = 9; i >=0; i--){
			System.out.print(numeros[i] + " ");
		}
	}
	public static void main(String args[]) {
		Principal5 principal = new Principal5();
		principal.leeNum();
		principal.numInv();
	}
}
