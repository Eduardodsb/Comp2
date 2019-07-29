package aula8;
import java.util.ArrayList;
import java.util.List;
public class SubList {
	public static void main( String[] args ) {
        List<String> dias = new ArrayList<String>();

        dias.add( "Domingo" );
        dias.add( "Segunda" );
        dias.add( "Terça" );
        dias.add( "quarta" );
        dias.add( "Quinta" );
        dias.add( "Sexta" );
        dias.add( "Sábado" );
        
        List<String> util = dias.subList( 1, 6 );

        System.out.println( util );
    }
}
