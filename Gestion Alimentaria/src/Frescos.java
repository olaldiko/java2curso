import java.util.Date;


public class Frescos extends Producto {
	Date envasado;
	String pais;
	public Frescos(String nombre, Date caducidad, int lote, Date envasado, String pais){
		this.nombre = nombre;
		this.caducidad = caducidad;
		 this.lote = lote;
		 this.envasado = envasado;
		  this.pais = pais;
	}
	public String toString(){
		return "Nombre: "+nombre+" Tipo: Frescos Lote: "+lote+"Caducidad: "+caducidad+" F. Envasado: "+envasado+" Pais: "+pais;
	}
}
