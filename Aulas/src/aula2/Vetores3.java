package aula2;

public class Vetores3 {

	public static void main(String[] args) {
		 String[] tab;

	        // Outra forma de inicializa��o din�mica
	        tab = new String[] { "a", "b", "c", "d" };
	        // � �til para passar vetores como par�metros para fun��es.

	        for( int i = 0; i < 4; i++ ) {
	            System.out.println( tab[i] );
	        }
	        
	        //Devemos sempre usar o campo length para acessar o n�mero de elementos de um vetor.

	        for( int i = 0; i < tab.length; i++ ) {
	            System.out.println( tab[i] );
	
	        }
	}
}
