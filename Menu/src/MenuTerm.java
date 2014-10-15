import java.util.Scanner;

public class MenuTerm {
	String[] opciones;
	Scanner teclado;
	int opcion;
	public void cargarMenu(String[] opciones){
		this.opciones = new String[opciones.length];
		for(int i = 0; i<= this.opciones.length;i++, this.opciones[i] = opciones[i]);
	}
	public int mostrarMenu(){
		for(int i = 0; i <= this.opciones.length; i++){
			System.out.println("\t"+(i+1) + ".- "+ opciones[i]);
		}
		teclado = new Scanner(System.in);
		System.out.print("Ïntroduce la opcion (1.." +this.opciones.length+ "): ");
		opcion = teclado.nextInt(); teclado.nextLine();
		return opcion;
	}
}
