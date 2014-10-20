import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;




public class GestionAliment {
	List<Producto> lista = new ArrayList<Producto>();
	int lote = 0;
	Scanner teclado = new Scanner(System.in);
	SimpleDateFormat formfecha = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat formhora = new SimpleDateFormat("hh/mm");
	public void addProducto(){
		
		int aukera = 0;
		System.out.println("Selecciona el tipo: ");
		do {
			System.out.println("1. Producto fresco");
			System.out.println("2. Producto refrigerado");
			System.out.println("3. Producto congelado");
			System.out.println("0. Salir");
			aukera = teclado.nextInt();
			teclado.nextLine();
			switch (aukera) {
			case 1:
					creaFresco();
				break;
			case 2:
					creaRefrigerado();
				break;
			case 3:
					creaCongelado();
				break;
			case 0:
				System.out.println("Agur!");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		} while (aukera != 0);
	}
	private void creaFresco() {
		String nombre;
		Date caducidad;
		Date envasado;
		String pais;
		try {
		System.out.println("Introduce el nombre");
		nombre = teclado.nextLine();
		System.out.println("Introduce la fecha(dd/mm/aaaa):");
		caducidad = formfecha.parse(teclado.nextLine());
		System.out.println("Introduce la fecha de envasado: (dd/mm/aaaa");
		envasado = formfecha.parse(teclado.nextLine());
		System.out.println("Introduce el pais de origen: ");
		pais = teclado.nextLine();
		lista.add(new Frescos(nombre, caducidad, lote, envasado, pais));
		lote++;
		} catch (ParseException e) {
			System.out.println("Error en la introduccion.");
		}
		
	}
	private void creaCongelado() {
		System.out.println("Selecciona el tipo: ");
		int aukera = 0;
		do {
			System.out.println("1. Congelado por aire");
			System.out.println("2. Congelado por agua");
			System.out.println("3. Congelado por nitrogeno");
			System.out.println("0. Salir");
			aukera = teclado.nextInt();
			teclado.nextLine();
			switch (aukera) {
			case 1:
				creaConAire();
				break;
			case 2:
				creaConAgua();
				break;
			case 3:
				creaConNitro();
				break;
			case 0:
				System.out.println("Agur!");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		} while (aukera != 0);
	}
private void creaConAgua() {
		String nombre;
		Date caducidad;
		Date fecha;
		String pais;
		int temp;
		Double salinidad;
		try {
			System.out.println("Introduce el nombre:");
			nombre = teclado.nextLine();
			System.out.println("Introduce la fecha de caducidad(dd/mm/aaaa)");
			caducidad = formfecha.parse(teclado.nextLine());
			System.out.println("Introuduce la fecha de envasado: (dd/mm/aaaa)");
			fecha = formfecha.parse(teclado.nextLine());
			System.out.println("Introduce el pais de origen: ");
			pais = teclado.nextLine();
			System.out.println("Introduce la temperatura: ");
			temp = teclado.nextInt(); teclado.nextLine();
			System.out.println("Introduce la salinidad: ");
			salinidad = teclado.nextDouble(); teclado.nextLine();
			lista.add(new CongelAgua(nombre, caducidad, lote, fecha, pais, temp, salinidad));
			lote++;
		} catch (Exception e) {
			System.out.println("Error al introducir los datos.");
		}
		
		
	}
	private void creaConAire() {
		String nombre;
		Date caducidad;
		Date fecha;
		String pais;
		int temp;
		Double porcenNitro;
		Double porcenOxi;
		Double porcenCO2;
		Double porcenAgua;
		try {
			System.out.println("Introduce el nombre:");
			nombre = teclado.nextLine();
			System.out.println("Introduce la fecha de caducidad(dd/mm/aaaa)");
			caducidad = formfecha.parse(teclado.nextLine());
			System.out.println("Introuduce la fecha de envasado: (dd/mm/aaaa)");
			fecha = formfecha.parse(teclado.nextLine());
			System.out.println("Introduce el pais de origen: ");
			pais = teclado.nextLine();
			System.out.println("Introduce la temperatura: ");
			temp = teclado.nextInt(); teclado.nextLine();
			System.out.println("Introduce el porcentaje de Nitrogeno:");
			porcenNitro = teclado.nextDouble(); teclado.nextLine();
			System.out.println("Introduce el porcentaje de O2:");
			porcenOxi = teclado.nextDouble(); teclado.nextLine();
			System.out.println("Introduce el porcentaje de CO2: ");
			porcenCO2 = teclado.nextDouble(); teclado.nextLine();
			System.out.println("Introduce el porcentaje de agua: ");
			porcenAgua = teclado.nextDouble(); teclado.nextLine();
			lista.add(new CongelAire(nombre, caducidad, lote, fecha, pais, temp, porcenNitro, porcenOxi, porcenCO2, porcenAgua));
			lote++;
		}catch(Exception e){
			System.out.println("Error al introducir los datos");
		}
	}
	private void creaConNitro(){
		String nombre;
		Date caducidad;
		Date fecha;
		String pais;
		int temp;
		String metodo;
		Date exposicion;
		try {
			System.out.println("Introduce el nombre:");
			nombre = teclado.nextLine();
			System.out.println("Introduce la fecha de caducidad(dd/mm/aaaa)");
			caducidad = formfecha.parse(teclado.nextLine());
			System.out.println("Introuduce la fecha de envasado: (dd/mm/aaaa)");
			fecha = formfecha.parse(teclado.nextLine());
			System.out.println("Introduce el pais de origen: ");
			pais = teclado.nextLine();
			System.out.println("Introduce la temperatura: ");
			temp = teclado.nextInt(); teclado.nextLine();
			System.out.println("Introduce el metodo utilizado");
			metodo = teclado.nextLine();
			System.out.println("Introduce el tiempo de exposicion: ");
			exposicion = formhora.parse(teclado.nextLine());
			lista.add(new CongelNitro(nombre, caducidad, lote, fecha, pais, temp, metodo, exposicion));
			lote++;
		}catch(Exception e){
			System.out.println("Error al introducir los datos");
		}
		
	}
	private void creaRefrigerado() {
		String nombre;
		Date caducidad;
		int supervisor;
		int temp;
		String pais;
		try {
			System.out.println("Introduce el nombre: ");
			nombre = teclado.nextLine();
			System.out.println("Introduce la fecha de caducidad");
			caducidad = formfecha.parse(teclado.nextLine());
			System.out.println("Introduce el codigo de supervisor");
			supervisor = teclado.nextInt(); teclado.nextLine();
			System.out.println("Introduce la temperatura");
			temp = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Introduce el pais de origen");
			pais = teclado.nextLine();
			lista.add(new Refrigerados(nombre, caducidad, lote, supervisor, temp, pais));
			lote++;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void verProductos(){
		ListIterator<Producto>it = lista.listIterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	public void menuPrincipal(){
		int aukera = 0;
		do {
			System.out.println("1. Crear producto");
			System.out.println("2. Ver productos");
			System.out.println("0. Salir");
			aukera = teclado.nextInt();
			teclado.nextLine();
			switch (aukera) {
			case 1:
				addProducto();
				break;
			case 2:
				verProductos();
				break;
			case 0:
				System.out.println("Agur!");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		} while (aukera != 0);
	}
	public static void main(String[] args) {
		GestionAliment gest = new GestionAliment();
		gest.menuPrincipal();
	}

}
