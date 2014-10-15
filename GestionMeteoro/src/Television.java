
public class Television extends ClientesObservacion {
	String comunidad;
	public Television(String nombre, String comunidad) {
		super(nombre);
		this.comunidad = comunidad;
	}

	public String toString(){
		return "Television "+nombre+" Com: "+comunidad;
	}
}
