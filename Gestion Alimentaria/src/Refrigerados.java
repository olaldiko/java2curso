import java.util.Date;


public class Refrigerados extends Producto {
	int supervisor;
	int temp;
	String pais;
	
	public Refrigerados(String nombre, Date caducidad, int lote, int superb, int temp, String pais){
		this.nombre = nombre;
		this.caducidad = caducidad;
		this.lote = lote;
		supervisor = superb;
		this.temp = temp;
		this.pais = pais;
	}
	public String toString(){
		return "Nombre: "+nombre+" Tipo: Refrigerado Lote: "+lote+" Caducidad: "+caducidad+" Supervisor: "+supervisor+" Temperatura recomendada: "+temp+" Pais: "+pais;
	}
}
