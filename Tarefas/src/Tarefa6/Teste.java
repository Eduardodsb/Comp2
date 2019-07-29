package Tarefa6;

public class Teste {
	public static void main( String[] args ) {
        SortedMap<String, Integer> m = new SortedMap<String, Integer>();
        SortedMap<Integer, String> nMes = new SortedMap<Integer, String>();
        String mes = "Feve", resto = "reiro";

        m.put( "Janeiro", 31 );
        m.put( "Fevereiro", 28 );
        m.put( "Marco", 28 );
        m.put( "Hoje", 28 );
        m.put( "Navio", 28 );
        
        nMes.put( 2, "Fevereiro" );
        

        System.out.println( "FEV: " + m.get( mes + resto ) );
        // Imprime 28

        m.put( "Fevereiro", 29 );

        System.out.println( m.get( "Fevereiro" ) );
        // Imprime 29
        
        System.out.println( m.get( "Janeiro" ) );
        // Imprime 31

        
        Vector<String> chave = m.keys();
        for( int i = 0; i < chave.size(); i++ )
            System.out.println( chave.at( i ) + "=>" + m.get( chave.at( i ) ) );

        //for( String k : m.keys() )
        //	System.out.println( k + " => " + m.get( k );

       
        m.remove( "Janeiro" );

        System.out.println( m.get( "Fevereiro" ).getClass().getName() );
        int numDias = m.get( "Fevereiro" );

        if( numDias < 30 )
            System.out.println( "Não tem 30" );
        
        System.out.println(m);
        
        m.put( "Janeiro", 31 );
        
        System.out.println(m);
    }
}
