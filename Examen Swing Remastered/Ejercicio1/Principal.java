import modelo.Modelo;
import vista.Vista;
import controlador.Controlador;


public class Principal {
	Modelo m = new Modelo();
	Vista v = new Vista();
	Controlador c = new Controlador(m, v);
	
	
	public static void main(String[] args){
		Principal p = new Principal();
	}
}
