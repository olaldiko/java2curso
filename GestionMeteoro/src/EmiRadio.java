
public class EmiRadio extends ClientesObservacion {

	String ciudad;
	public EmiRadio(String nombre){
		super(nombre);
	}
	public EmiRadio(String nombre, String ciudad){
		super(nombre);
		this.ciudad = ciudad;
	}
	public String toString(){
		return "Emisora de radio "+nombre;
	}
}
