package aula2;

public class Parâmetrosquesãovetores {
	//Os parâmetros vetores em Java são passados por referência (ponteiros), o que significa que serão alterados na rotina que chamou a subrotina.

	public static void main(String[] args) {
		String[] tab = new String[] { "z", "g", "a", "k", "ff", "w", "wz", "wa" };

        System.out.println( tab[0] );
        teste( tab );
        System.out.println( tab[0] );
    }

    public static void teste( String[] v ) {
        v[0] = "Mudou";
	}

}
