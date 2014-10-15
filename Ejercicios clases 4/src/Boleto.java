import java.util.Scanner;


public class Boleto {
	int numeros[];
	int cantN;
	public Boleto(int cant, int numeros[]){
		numeros = new int[cant];
		for(int i = 0; i < this.numeros.length; i++){
			this.numeros[i] = numeros[i];
		}
	}
	public Boleto(int cant){
		numeros = new int[cant];
		for(int i = 0; i < cant; i++){
			numeros[i] = 0;
		}
		this.cantN = cant;
	}
	public void calcAcertados(Boleto b){
		int cont = 0;
		for(int i = 0; i < this.numeros.length;i++){
			for(int j = 0; j < this.numeros.length;j++){
				if(this.numeros[i] == b.numeros[j]){
					System.out.println("Numero "+b.numeros[i]+" ACERTADO!!!");
					cont++;
				}
			}
		}
		System.out.println("Total acertados: "+cont);
	}
	public String toString(){
		String numeros = "";
		for(int i = 0; i < this.numeros.length;i++){
			numeros += this.numeros[i];
			numeros += " ";
		}
		return numeros;
	}
	public void introduceBoleto(){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce los "+this.cantN+" numeros del boleto: ");			
		for(int i = 0; i < this.cantN; i++){
			this.numeros[i] = teclado.nextInt(); teclado.nextLine();
		}
	
	}
}