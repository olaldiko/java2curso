import java.util.Observable;




public class PuntoObservacion extends Observable{
	String nombre;
	Double temp;
	
	public PuntoObservacion(String nombre){
		this.nombre = nombre;
		this.temp = 0.0;
	}
	public void setTemp(Double temp){
		this.temp = temp;
		this.setChanged();
		this.notifyObservers(this);
	}
	public String toString(){
		return "Estacion "+nombre+" Temp: "+temp;
	}
}
