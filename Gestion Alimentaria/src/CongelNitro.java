import java.util.Date;


public class CongelNitro extends Congelados {
	String metodo;
	Date exposicion;
	public CongelNitro(String nombre, Date caducidad, int lote, Date fecha, String pais, int temp, String metodo, Date exposicion) {
		this.caducidad = caducidad;
		this.lote = lote;
		this.fecha = fecha;
		this.pais = pais;
		this.temp = temp;
		this.metodo = metodo;
		this.exposicion = exposicion;
	}
public String toString(){
	return "Nombre: "+nombre+" Tipo: Congelado por nitrogeno Lote: "+lote+" Caducidad: "+caducidad+" F.env: "
			+fecha+" Temp: "+temp+" Metodo: "+metodo+" T. Exposicion: "+exposicion;
}


}

