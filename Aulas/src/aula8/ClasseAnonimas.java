package aula8;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ClasseAnonimas {
    public static void main( String[] args ) {
        ArrayList<String> dias = new ArrayList<String>();

	       dias.add( "Domingo" );
	       dias.add( "Segunda" );
	       dias.add( "Ter�a" );
	       dias.add( "Quarta" );
	       dias.add( "Quinta" );
	       dias.add( "Sexta" );
	       dias.add( "S�bado" );

	        System.out.println( dias );

	        // Classe an�nima: classe que estende uma classe ou implementa uma interface
	        dias.removeIf( new Predicate<String>() {

	            @Override
	            public boolean test( String t ) {
	                return t.substring( t.length() - 1 ).compareTo( "a" ) == 0;
	            }

	        } );

	        System.out.println( dias );
	    }
	
}
/*
import java.util.ArrayList;
import java.util.function.Predicate;

public class Principal {

    public static void main( String[] args ) {
        ArrayList<String> dias = new ArrayList<String>();

        dias.add( "Domingo" );
        dias.add( "Segunda" );
        dias.add( "Ter�a" );
        dias.add( "Quarta" );
        dias.add( "Quinta" );
        dias.add( "Sexta" );
        dias.add( "S�bado" );

        String ultimo = "a";
        
        System.out.println( dias );

        // Classe an�nima: classe que estende uma classe ou implementa uma interface
        dias.removeIf( new Predicate<String>() {

            @Override
            public boolean test( String t ) {
                return t.substring( t.length() - 1 ).compareTo( ultimo ) == 0;
            }

        } );

        System.out.println( dias );
    }
}
*/