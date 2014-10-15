import java.util.Scanner;


public class JuegoNumeros {
	ListaNumeros lista = new ListaNumeros();
	Scanner teclado = new Scanner(System.in);
	public void preguntar(){
		int heridos;
		int muertos;
		int acertado = 0;
		do{
		System.out.println(lista.ArrToInt(lista.listanumeros.get(0)));
		System.out.println("Introduce los muertos");
		muertos= teclado.nextInt(); teclado.nextLine();
		System.out.println("Introduce los heridos");
		heridos = teclado.nextInt(); teclado.nextLine();
		acertado = lista.comparaNum(muertos, heridos);
		}while(acertado == 0);
		if(acertado == 1){
			System.out.println("El numero es"+lista.ArrToInt(lista.listanumeros.get(0)));
		}else{
			System.out.println("Has hecho trampa");
		}
		
	}
}
