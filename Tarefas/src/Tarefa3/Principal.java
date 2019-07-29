package Tarefa3;


public class Principal {

	public static void main(String[] args) throws Exception {
		Data d =  new Data();
		d.setData(17,13,2017);

		System.out.println(d.verificaData());
		
		System.out.println(d.toString());
	}

}
