import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class GestionCoches {
	List<Coche> listacoches = new ArrayList<Coche>();
	Scanner teclado = new Scanner(System.in);
	
	public void addCoche(){
		try{
		String matricula;
		String bastidor;
		Persona propietario;
		String ciudad;
		Coche coche;
		System.out.println("Introduce la matricula(0000-ZZZ)");
		matricula = teclado.nextLine();
		System.out.println("Introduce el numero de bastidor(ZZ00000000)");
		bastidor = teclado.nextLine();
		propietario = introducePersona();
		System.out.println("Introduce la ciudad:");
		ciudad = teclado.nextLine();
		coche = new Coche(matricula, bastidor, propietario, ciudad);
		if(!chequeoIguales(coche)){
			listacoches.add(coche);
		}else{
			System.out.println("El coche que intentas anadir ya existe");
		}
		}catch (CarException e){
			System.out.println(e.toString());
		}catch(Exception e){
			System.out.println("Error al introducir los datos del usuario");
		}
	}
	public Persona introducePersona()throws Exception{
		Persona pers = new Persona();
		System.out.println("Introduce el nombre:");
		pers.setNombre(teclado.nextLine());
		System.out.println("Introduce el apellido:");
		pers.setApellido(teclado.nextLine());
		return pers;
	}
	public void verCoches(){
		ListIterator<Coche> it = listacoches.listIterator();
		Coche c;
		System.out.println("Matricula Bastidor Nombre Apellido Ciudad");
		while(it.hasNext()){
			c = it.next();
			System.out.println(c.toString());
		}
	}
	public boolean chequeoIguales(Vehiculo c){
		ListIterator<Coche> it = listacoches.listIterator();
		Vehiculo clista;
		while(it.hasNext()){
			clista = (Vehiculo) it.next();
			if(c.compare(clista, c) == 0){
				return true;
			}
		}
		return false;
	}
	public void menuPrincipal(){
		int aukera;
		Scanner teclado = new Scanner(System.in);
		do{
			System.out.println("1. Anadir un vehiculo");
			System.out.println("2. Ver los coches en la lista");
			aukera = teclado.nextInt();
			switch(aukera){
			case 1:
				addCoche();
				break;
			case 2:
				verCoches();
			}
		}while(aukera != 0);
		
	}
	public static void main(String args[]){
		GestionCoches gest = new GestionCoches();
		gest.menuPrincipal();
	}
}
