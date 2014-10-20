import java.util.Date;


public class CongelAire extends Congelados {
	Double porcenNitro;
	Double porcenOxi;
	Double porcenCO2;
	Double porcenAgua;
	

	public CongelAire(String nombre, Date caducidad, int lote, Date fecha, String pais, int temp, Double porcenNitro, Double porcenOxi, Double porcenCO2,
			Double porcenAgua) {
		this.nombre = nombre;
		this.caducidad = caducidad;
		this.lote = lote;
		this.fecha = fecha;
		this.pais = pais;
		this.temp = temp;
		this.porcenNitro = porcenNitro;
		this.porcenOxi = porcenOxi;
		this.porcenCO2 = porcenCO2;
		this.porcenAgua = porcenAgua;
	}


	@Override
	public String toString() {
		return "Nombre: "+nombre+"Tipo: Congelado Por Aire Lote: "+lote+" Caducidad: "+caducidad+" F.env: "
	+fecha+" Temp: "+temp+" %N: "+porcenNitro+" %O2: "+porcenOxi+
	" %CO2: "+porcenCO2+" %Agua: "+porcenAgua;
	}
}
