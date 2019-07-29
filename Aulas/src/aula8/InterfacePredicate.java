package aula8;
import java.util.ArrayList;
import java.util.function.Predicate;
public class InterfacePredicate {
	static class Filtro implements Predicate<String> {

        @Override
        public boolean test( String t ) {
            String ultimo = t.substring( t.length()-1 );
            
            if( ultimo.compareTo( "o" ) == 0 )
                return true;
            else
                return false;
        }   
    }
    
    public static void main( String[] args ) {
        Filtro f = new Filtro();
        ArrayList<String> dias = new ArrayList<String>();

        dias.add( "Domingo" );
        dias.add( "Segunda" );
        dias.add( "Terça" );
        dias.add( "Quarta" );
        dias.add( "Quinta" );
        dias.add( "Sexta" );
        dias.add( "Sábado" );

        System.out.println( dias );

        dias.removeIf( f );
        
        System.out.println( dias );
    }
}
