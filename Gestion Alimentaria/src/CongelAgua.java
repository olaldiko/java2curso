import java.util.Date;


public class CongelAgua extends Congelados {
	Double salinidad;
	public CongelAgua(String nombre, Date caducidad, int lote, Date fenv, String pais, int temp, Double salinidad){
		this.nombre = nombre;
		this.caducidad = caducidad;
		this.lote = lote;
		this.fecha = fenv;
		this.pais = pais;
		this.temp = temp;
		this.salinidad = salinidad;
	}
	public String toString(){
		return "Nombre: "+nombre+" Tipo: Congelado por Agua "+"Lote: "+lote+" Caducidad: "+caducidad+" F. envasado: "+fecha+" Temp: "+temp+" salinidad%: "+salinidad;
	}
}
