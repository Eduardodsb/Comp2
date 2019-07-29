package aula8;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class replaceAlleUnaryOperator {
	public static void main( String[] args ) {
        ArrayList<String> dias = new ArrayList<String>();

        dias.add( "Domingo" );
        dias.add( "Segunda" );
        dias.add( "Ter�a" );
        dias.add( "quarta" );
        dias.add( "Quinta" );
        dias.add( "Sexta" );
        dias.add( "S�bado" );

        dias.replaceAll( new UnaryOperator<String>() {
            @Override
            public String apply( String t ) {
                return t.toUpperCase();
            }
        });
        
        System.out.println( dias );
    }
}
