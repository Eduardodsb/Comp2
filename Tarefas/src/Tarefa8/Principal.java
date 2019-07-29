package Tarefa8;

public class Principal {

	public static void main(String[] args) {
		ComparaFonetica a = new ComparaFonetica();
        a.put("x", "ch");
        a.put("ç", "ss");
        a.put("k", "qu");
        a.put("z","s");
        a.put("s","sc");
        a.put("je","ge");
        a.put("ji","gi");
        a.put("l","r");
        
        System.out.println(a.equivalente("chuxu","xuxu"));//imprime verdadeiro
        System.out.println(a.equivalente("placa","praca"));//imprime verdadeiro
        System.out.println(a.equivalente("problema","probrema"));//imprime verdadeiro
        System.out.println(a.equivalente("xoxana","xochana"));//imprime falso

	}

}
