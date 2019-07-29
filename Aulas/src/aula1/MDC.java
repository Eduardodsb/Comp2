package aula1;
public class MDC {

	public static void main(String[] args) {
		int x = 72, y = 33;
		
		System.out.println("O mdc entre "+ x +" e "+ y +" é: "+ mdc(x,y));
	}

	public static int mdc(int x, int y){
		return y == 0? x : mdc(y, x%y);
	}
}
