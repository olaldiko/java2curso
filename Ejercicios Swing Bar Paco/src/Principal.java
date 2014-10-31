
public class Principal {
	Bar b = new Bar();
	Controlador c = new Controlador();
	Interfaz i = new Interfaz();
	public static void main(String[] args){
		Principal p = new Principal();
		p.c.b = p.b;
		p.c.i = p.i;
		p.i.c = p.c;
		p.i.creaVentana();
	}
}
