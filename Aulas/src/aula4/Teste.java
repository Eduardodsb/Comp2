package aula4;

public class Teste {
	
    public static void main( String argc[] ){
        Data d[] = new Data[3];

        try {
            for( int i = 0; i < d.length; i++ )
                d[i] = new Data();
            
            d[2].setData( 28, 123, 2017 );
            System.out.println( d[2] );
       } catch( ExcecaoDataInvalida2 e ) {
            System.out.println( "Deu exceção data inválida" );
        } catch( Exception e ) {
            e.printStackTrace();
            System.out.println( "Exceção genérica" );
        } finally {
            System.out.println( "Executado sim ou sim!" );
        }
     
        
        
        
        System.out.println("printa aqui tb");
    }
}