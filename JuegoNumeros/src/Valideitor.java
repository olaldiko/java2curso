
public class Valideitor implements Validador{
	public boolean validar(Integer[] num){
		if(num[0] == 0){
			return false;
		}
		for(int i = 0; i < num.length; i ++){
			for(int j = num.length; j > i; j--){
				if(num[i] == num[j]){
					return false;
				}
			}
		}
		return true;
	}
}
