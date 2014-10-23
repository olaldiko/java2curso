


public class Hora implements Comparable<Hora>{
	int hh;
	int mm;
	public Hora(int hh, int mm){
		if(checkeoHora(hh, mm)){
			this.hh = hh;
			this.mm = mm;
		}else{
			this.hh = 0;
			this.mm = 0;
		}
	}
	public boolean checkeoHora(int hh2, int mm2) {
		if(((hh>=0)&&(hh <=23))&&((mm>=0)&&(mm<=59))){
			return true;
		}else{
		return false;
		}
	}
	@Override
	public int compareTo(Hora o) {
		if(hh == o.hh){
			if(mm == o.mm){
				return 0;
			}else{
				if(mm > o.mm){
					return 1;
				}else{
					return -1;
				}
			}
		}else{
			if(hh > o.hh){
				return 1;
			}else{
				return -1;
			}
		}
	}

	public String toString(){
		return hh+":"+mm;
	}

}

