
public class Bar {
	Double cuenta = 0.0;
	Double pcana = 1.5;
	Double ppintxo = 1.2;
	Double pvino = 1.5;
		
	public void sumaCana() {
		cuenta += pcana;
	}

	public void sumaVino() {
		cuenta += pvino;
	}

	public void sumaPintxo() {
		cuenta += ppintxo;
	}
	public Double getCuenta(){
		return cuenta;
	}
	public void resetCuenta(){
		cuenta = 0.0;
	}

}
