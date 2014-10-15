import java.util.Scanner;


public class GestionBanco {
		final int MAX_CUENTAS = 100;
		Scanner teclado = new Scanner(System.in);
		CB cuentas[] = new CB[MAX_CUENTAS];
		CB cuentaenuso;
		int numCuentas;
	public void menuPrinc(){
		int aukera;
		do{
		System.out.println("1. Añadir una cuenta");
		System.out.println("2. Realizar una transferencia a una cuenta");
		System.out.println("3. Ver balance de una cuenta");
		System.out.println("4. Retirar dinero desde una cuenta");
		System.out.println("5. Ingresar dinero a una cuenta");
		System.out.println("0. Salir");
		aukera = teclado.nextInt(); teclado.nextLine();
		switch(aukera){
		case 1:
			addCuentaMTerm();
			break;
		case 2:
			transferenciaTerm();
			break;
		case 3:
			verBalanceTerm();
			break;
		case 4:
			retirarDineroTerm();
			break;
		case 5:
			ingresarDineroTerm();
			break;
		case 0:
			System.out.println("Gracias por utilizar la aplicacion");
			break;
		default:
			System.out.println("Opcion equivocada");
		
		}
		}while(aukera != 0);
	}
	/**
	 * Crea una nueva cuenta en el programa
	 */
	public void addCuentaMTerm(){
		cuentas[numCuentas] = new CB();
		System.out.println("Introduce el nombre del titular: ");
		cuentas[numCuentas].titular.setNombre(teclado.nextLine());
		System.out.println("Ïntroduce el apellido del titular: ");
		cuentas[numCuentas].titular.setApellido(teclado.nextLine());
		System.out.println("Introduce la cantidad inicial de la cuenta");
		cuentas[numCuentas].addDinero(teclado.nextDouble()); teclado.nextLine();
		System.out.println("La ID de la cuenta sera: ****    "+cuentas[numCuentas].getID()+"   ****");
		numCuentas++;
	}
	/**
	 * Transfiere dinero entre dos cuentas
	 */
	
	public void transferenciaTerm(){
		Double cantidad;
		CB cuenta1, cuenta2;
		String aukera;
		System.out.println("Selecciona la cuenta de origen: ");
		cuenta1 = selectCuenta();
		System.out.println("Selecciona la cuenta de destino: ");
		cuenta2 = selectCuenta();
		System.out.println("Selecciona la cantidad a transferir: ");
		cantidad = teclado.nextDouble(); teclado.nextLine();
		
		if(((cuenta1 != null) && (cuenta2 != null))&&(cuenta1 != cuenta2)){
			System.out.println("Se van a transferir "+cantidad+" eur desde la cuenta de "+cuenta1.titular+" a la cuenta de "+cuenta2.titular);
			System.out.println(" Quieres continuar? (s/n)");
			aukera = teclado.nextLine();
			if(aukera.toLowerCase().equals("s")){
				if(cuenta1.transferirA(cuenta2, cantidad)){
					System.out.println("Transferencia realizada con exito");
				}else{
					System.out.println("Error, fondos insuficientes");
				}
			}else{
				System.out.println("Se ha cancelado la operacion.");
			}
		}else{
			System.out.println("Ërror al seleccionar las cuentas o cantidad");
		}
	}
	/**
	 * Muestra el balance de una cuenta;
	 */
	public void verBalanceTerm(){
		CB cuenta;
		System.out.println("Selecciona la cuenta: ");
		cuenta = selectCuenta();
		if(cuenta != null){
			System.out.println("El balance de la cuenta es de "+cuenta.getCantidad()+" eur.");
		}
	}
	/**
	 * Retira el dinero de una cuenta
	 */
	public void retirarDineroTerm(){
		CB cuenta;
		Double cantidad;
		System.out.println("Selecciona una cuenta");
		cuenta = selectCuenta();
		if(cuenta != null){
			System.out.println("Cuanto dinero quieres retirar? MAX: "+cuenta.getCantidad());
			cantidad = teclado.nextDouble(); teclado.nextLine();
			if(cuenta.remDinero(cantidad)){
				System.out.println("Öperacion realizada con exito");
			}else{
				System.out.println("Error, fondos insuficientes");
			}
		}
	}
	/**
	 * Ingresa dinero a una cuenta
	 */
	public void ingresarDineroTerm(){
		CB cuenta;
		System.out.println("Selecciona la cuenta: ");
		cuenta = selectCuenta();
		if(cuenta != null){
			System.out.println("Introduce la cantidad a ingresar: ");
			cuenta.addDinero(teclado.nextDouble()); teclado.nextLine();
			System.out.println("Se ha añadido el dinero correctamente");
		}else{
			System.out.println("Error al elegir la cuenta");
		}
	}
	/**
	 * Muestra todas las cuentas
	 */
	public void mostrarCuentas(){
		for(int i = 0; i < numCuentas;i++){
			System.out.println(cuentas[i]);
		}
	}
	/**
	 * Selecciona una cuenta entre las disponibles
	 * @return 
	 */
	public CB selectCuenta(){
		int select = 0;
		for(int i =0; i < numCuentas;i++){
			System.out.print((i+1)+". ");
			System.out.println(cuentas[i]);
		}
		select = teclado.nextInt(); teclado.nextLine();
		if((select < 1)||(select > numCuentas)){
			System.out.println("Error, cuenta no valida");
			return null;
		}else{
			return cuentas[select-1];
		}
	}
	
}
