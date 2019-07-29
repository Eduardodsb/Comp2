package aula2;

public class Variáveisdeloop {
	//Variáveis de loop podem e devem ser declaradas na inicialização do Loop

	public static void main(String[] args) {
		// Em java podemos declarar uma variável de loop na inicialização
        for( int i = 0; i < 10; i++ )
            System.out.println( i );

        // Erro: a variável i só existe detnro do for
        //System.out.println( "==> " + i );

	}

}
