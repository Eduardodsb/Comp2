package aula2;

public class Vari�veisdeloop {
	//Vari�veis de loop podem e devem ser declaradas na inicializa��o do Loop

	public static void main(String[] args) {
		// Em java podemos declarar uma vari�vel de loop na inicializa��o
        for( int i = 0; i < 10; i++ )
            System.out.println( i );

        // Erro: a vari�vel i s� existe detnro do for
        //System.out.println( "==> " + i );

	}

}
