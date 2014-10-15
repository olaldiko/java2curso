import java.util.Scanner;


public class AgendaTel {
	Scanner teclado = new Scanner(System.in);
	Contactos[] contact = new Contactos[100];
	int numCont = 0;
	
	public void menuPrinc(){
		int aukera;
		do{
		System.out.println("1. Añadir un nuevo contacto");
		System.out.println("2. Buscar un contacto");
		System.out.println("3. Mostrar toda la agenda");
		System.out.println("0. Salir");
		aukera = teclado.nextInt(); teclado.nextLine();
		switch(aukera){
		case 1:
			addPersTerm();
			break;
		case 2:
			buscaContactoTerm();
			break;
		case 3:
			listaContactosTerm();
			break;
		case 0:
			System.out.println("Gracias por utilizar la aplicacion");
			break;
		default:
			System.out.println("Opcion equivocada");
		
		}
		}while(aukera != 0);
	}
	public void addPersTerm(){
		contact[numCont]= new Contactos();
		System.out.println("Introduce el nombre: ");
		contact[numCont].setNombre(teclado.nextLine());
		System.out.println("Introduce el apellido: ");
		contact[numCont].setApellido(teclado.nextLine());
		System.out.println("Introduce el numero de telefono: ");
		contact[numCont].setTelefono(teclado.nextLine());
		System.out.println("Introduce el email: ");
		contact[numCont].setEmail(teclado.nextLine());
		numCont++;
		System.out.println("Creado con exito");
	}
	public void buscaContactoTerm(){
		String nombre;
		boolean encontrado = false;
		System.out.println("Introduce el nombre o el apellido de la persona a buscar: ");
		nombre = teclado.nextLine();
		for(int i = 0; i < numCont; i++){
			if((nombre.toLowerCase().equals(contact[i].getNombre()))||(nombre.toLowerCase().equals(contact[i].getApellido()))){
				System.out.println(contact[i]);
				encontrado = true;
			}
		}
		if(!encontrado){
			System.out.println("Lo sentimos, el contacto no se ha encontrado");
		}
	}
	public void listaContactosTerm(){
		for(int i = 0; i < numCont; i++){
			System.out.println(contact[i]);
		}
	}
}