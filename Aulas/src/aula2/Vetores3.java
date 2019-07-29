package aula2;

public class Vetores3 {

	public static void main(String[] args) {
		 String[] tab;

	        // Outra forma de inicialização dinâmica
	        tab = new String[] { "a", "b", "c", "d" };
	        // É útil para passar vetores como parâmetros para funções.

	        for( int i = 0; i < 4; i++ ) {
	            System.out.println( tab[i] );
	        }
	        
	        //Devemos sempre usar o campo length para acessar o número de elementos de um vetor.

	        for( int i = 0; i < tab.length; i++ ) {
	            System.out.println( tab[i] );
	
	        }
	}
}
