package aula2;

public class Par�metrosques�ovetores {
	//Os par�metros vetores em Java s�o passados por refer�ncia (ponteiros), o que significa que ser�o alterados na rotina que chamou a subrotina.

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
