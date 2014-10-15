import java.util.Scanner;


public class Principal {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Hora a = new Hora();
		Hora b = new Hora();
		System.out.println("Vamos a calcular la diferencia entre dos horas, introduce las horas de la primera:");
		a.setHoras(teclado.nextInt());
		teclado.nextLine();
		System.out.println("Ahora los minutos:");
		a.setMinutos(teclado.nextInt());
		teclado.nextLine();
		System.out.println("Ahora a por la segunda, introduce las horas:");
		b.setHoras(teclado.nextInt());
		teclado.nextLine();
		System.out.println("Y los minutos:");
		b.setMinutos(teclado.nextInt());
		teclado.nextLine();
		
		System.out.println("La diferencia entre las dos horas es de "+a.calcDiff(b)+" minutos");
		
	}

}
