
public class Hora {
	int horas;
	int minutos;
	
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int calcDiff(Hora x){
		return Math.abs(((this.horas*60)+this.minutos)-((x.horas*60)+x.minutos));
	}
}
