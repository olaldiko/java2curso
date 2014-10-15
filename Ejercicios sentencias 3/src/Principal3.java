
public class Principal3 {
	private static int numeros;
	public static void sumimpares(){
		for(int i = 0;i <= 10; i++){
			if(i%2 == 0){
				numeros += i;
			}
		}
		System.out.println("La suma de todos los numeros pares del 1 al 10 es: "+numeros);
	}
	
	public static void main(String args[]){
	sumimpares();	
	}
}
