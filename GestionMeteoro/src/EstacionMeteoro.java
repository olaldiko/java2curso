
public class EstacionMeteoro extends ClientesObservacion {
	String ubicacion;
	public EstacionMeteoro(String nombre, String ubicacion) {
		super(nombre);
		this.ubicacion = ubicacion;
	}
	public String toString(){
		return "Estacion meteorologica "+nombre+" Ubicacion: "+ubicacion;
	}

}
