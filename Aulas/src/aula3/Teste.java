package aula3;

public class Teste {
	public static void main(String argc[]){
		Data d = new Data();
		
		d.setAno(2017);
		d.setMes(17);
		d.setDia(10);
		
		System.out.println(d.getDia() + "/" + d.getMes() + "/" + d.getAno());
		
	}
}
