import java.util.Observable;
import java.util.Observer;


public class ClientesObservacion implements Observer{
	String nombre;
	PuntoObservacion p;
	public ClientesObservacion(String nombre){
		this.nombre = nombre;
	}
	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof Double){
		System.out.println(this+" Datos modificados: "+arg.toString());
		}
		
	}
	public String toString(){
		return "Observador "+nombre;
	}
}
