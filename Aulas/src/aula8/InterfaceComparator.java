package aula8;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class InterfaceComparator {

    public static void main( String[] args ) {
        ArrayList<String> dias = new ArrayList<String>();

        dias.add( "Domingo" );
        dias.add( "Segunda" );
        dias.add( "Terça" );
        dias.add( "quarta" );
        dias.add( "Quinta" );
        dias.add( "Sexta" );
        dias.add( "Sábado" );

        dias.sort( new Comparator<String>() {
            @Override
            public int compare( String o1, String o2 ) {
                return o2.compareToIgnoreCase( o1 );
            }
        });
        
        System.out.println( dias );
    }
}
