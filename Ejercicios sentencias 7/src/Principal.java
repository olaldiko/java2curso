import java.util.Scanner;


public class Principal {
	Scanner teclado;
	int[] numeros;
	
	public static void main(String[] args){
		Principal princi = new Principal();
		princi.teclado = new Scanner(System.in);
		princi.numeros = new int[10];
		princi.leeNumNR();
		princi.mostrarNum();
		
	}
	public void leeNumNR(){
		System.out.println("Introduce 10 numeros no repetido: ");
		for(int i = 0; i < numeros.length; i++){
			numeros[i] = teclado.nextInt(); teclado.nextLine();
			for(int j = 0; j < i; j++){
				if(numeros[j] == numeros[i]){
					System.out.println("Ël numero esta duplicado!");
					i--;
				}
			}
		}
	}
	public void mostrarNum(){
		for(int i = 0; i <numeros.length;i++){
			System.out.println(numeros[i]);
		}
	}
}
