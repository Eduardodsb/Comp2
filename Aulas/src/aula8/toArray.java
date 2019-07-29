package aula8;
import java.util.ArrayList;
import java.util.List;
public class toArray {
	public static void main( String[] args ) {
        List<String> dias = new ArrayList<String>();

        dias.add( "Domingo" );
        dias.add( "Segunda" );
        dias.add( "Terça" );
        dias.add( "quarta" );
        dias.add( "Quinta" );
        dias.add( "Sexta" );
        dias.add( "Sábado" );

        String str[] = dias.toArray( new String[] {} );

        for( Object x : dias.toArray() )
            System.out.println( (String) x + "!" );

        System.out.println( str[1] );
    }
}
