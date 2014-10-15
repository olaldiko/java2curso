import java.util.*;



public class GestionMeteoro {
	List<ClientesObservacion> listaCli = new ArrayList<ClientesObservacion>();
	List<PuntoObservacion> listaPoint = new ArrayList<PuntoObservacion>();
	Scanner teclado = new Scanner(System.in);
	
	
	public void introducirPunto(){
		String nombre;
		System.out.println("Introduce el nombre del nuevo punto: ");
		nombre = teclado.nextLine();
		listaPoint.add(new PuntoObservacion(nombre));
	}
	public void anadirCliente(){
		String nombre;
		int tipo;
		System.out.println("Introduce el nombre del nuevo cliente: ");
		nombre = teclado.nextLine();
		do{
			System.out.println("Introduce el tipo:");
			System.out.println("1. Estacion meteorologica");
			System.out.println("2. Emisora de radio");
			System.out.println("3. Television");
			tipo = teclado.nextInt(); teclado.nextLine();
			switch(tipo){
			case 1:
				System.out.println("Introduce la ubicacion:");
				listaCli.add(new EstacionMeteoro(nombre, teclado.nextLine()));
				break;
			case 2:
				System.out.println("Introduce la ciudad: ");
				listaCli.add(new EmiRadio(nombre, teclado.nextLine()));
				break;
			case 3:
				System.out.println("Introduce la comunidad");
				listaCli.add(new Television(nombre, teclado.nextLine()));
				break;
			default:
				System.out.println("Tipo incorrecto");
				break;
			}
			
		}while((tipo < 1)||(tipo > 3));
	}
	public void vincCliaPunto(){
		ClientesObservacion cli;
		PuntoObservacion point;
		System.out.println("Selecciona un cliente: ");
		cli = selectCliente();
		System.out.println("Selecciona un punto: ");
		point = selectPunto();
		cli.p = point;
		
		point.addObserver(cli);
		System.out.println("Cliente anadido a la lista para notificacion del punto, ahora hay "+point.countObservers()+" subscritos");
	}
	public void verClientes(){
		ListIterator<ClientesObservacion> it = listaCli.listIterator();
		int i = 1;
		System.out.println("*******************************************");
		while(it.hasNext()){
			System.out.println(i+". "+it.next().toString());
			i++;
		}
		System.out.println("*******************************************");
	}
	public ClientesObservacion selectCliente(){
		int aukera = 0;
		do{
		verClientes();
		System.out.println("Selecciona un cliente:");
		aukera = teclado.nextInt(); teclado.nextLine();
		}while((aukera < 1)||(aukera > listaCli.size()));
		return listaCli.get(aukera-1);
		
	}
	public void verPuntos(){
		ListIterator<PuntoObservacion> it = listaPoint.listIterator();
		int i = 1;
		System.out.println("*******************************************");
		while(it.hasNext()){
			System.out.println(i+". "+it.next());
			i++;
		}
		System.out.println("*******************************************");
	}
	public PuntoObservacion selectPunto(){
		int aukera = 0;
		do{
		verPuntos();
		System.out.println("Selecciona un punto:");
		aukera = teclado.nextInt(); teclado.nextLine();
		}while((aukera < 1)||(aukera > listaPoint.size()));
		return listaPoint.get(aukera-1);
		
	}
	
	public void actualizaPunto(){
		PuntoObservacion p;
		Double temp;
		p = selectPunto();
		System.out.println("Introduce la lectura de temperatura: ");
		temp = teclado.nextDouble();
		p.setTemp(temp);
		System.out.println("Lectura actualizada");
	}
	public void menuPrincipal(){
		int aukera = 0;
		System.out.println("Bienvenido al programa de gestion de puntos meteorologicos, elige una opcion: ");
		
		do{
			System.out.println("1. Anadir un punto de observacion");
			System.out.println("2. Anadir un cliente");
			System.out.println("3. Vincular un punto a un cliente");
			System.out.println("4. Actualizar datos de un punto");
			System.out.println("5. Ver puntos de observacion");
			System.out.println("6. Ver cliuentes");
			System.out.println("0. Salir");
			aukera = teclado.nextInt(); teclado.nextLine();
			switch(aukera){
			case 1:
				introducirPunto();
				break;
			case 2:
				anadirCliente();
				break;
			case 3:
				vincCliaPunto();
				break;
			case 4:
				actualizaPunto();
				break;
			case 5:
				
				verPuntos();
				break;
			case 6:
				verClientes();
				break;
			case 0:
				System.out.println("Gracias por utilizar el programa");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		}while(aukera !=  0);
	}
	public static void main(String[] args) {
		GestionMeteoro gest = new GestionMeteoro();
		gest.menuPrincipal();
	}

}
