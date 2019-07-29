package Tarefa5;

public class Main {

	public static void main(String[] args) {
		Map m = new Map();

        m.put( "Janeiro", 31 );
        m.put( "Fevereiro", 28 );
        m.put( 1, "Janeiro" );
        // Nesse momento deve redminesionar o array para 4 posições.

        System.out.println( m.get( "Fevereiro" ) );
        // Imprime 28

        m.put( "Fevereiro", 29 );

        System.out.println( m.get( "Fevereiro" ) );
        // Imprime 29

        Object[] chaves = m.keys();

        for( int i = 0; i < chaves.length; i++ )
            System.out.println( chaves[i] + " ==> " + m.get( chaves[i] ) );

        m.remove( "Janeiro" );
        // Remove a chave 1 (cujo valor é "Janeiro")

	}

}
