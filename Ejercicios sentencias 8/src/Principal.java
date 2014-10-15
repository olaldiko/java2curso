import java.util.Scanner;


public class Principal {
		int[] numeros;
		int[] premiados;
		Scanner teclado;
	public static void main(String[] args) {
		Principal princi = new Principal();
		princi.teclado = new Scanner(System.in);
		princi.premiados = new int[] {4 , 8, 15, 16, 23, 42};
		princi.numeros = new int[6];
		princi.leeNum();
		princi.calcAcertados();
	}
	public void leeNum(){
		System.out.println("Introduce los numeros de la bonoloto: ");
		for(int i = 0; i < 6;i++){
			numeros[i] = teclado.nextInt(); teclado.nextLine();
		}
	}
	public void calcAcertados(){
		int cont = 0;
		for(int i = 0; i < numeros.length;i++){
			for(int j = 0; j < numeros.length;j++){
				if(numeros[i] == premiados[j]){
					System.out.println("Numero "+numeros[i]+" ACERTADO!!!");
					cont++;
				}
			}
		}
		System.out.println("Totales acertados : "+cont);
	}
}
