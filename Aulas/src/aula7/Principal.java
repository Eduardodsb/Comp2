package aula7;

import java.util.Iterator;

//Uma classe pode ser usada no for se ela implementar a interface Iterable.
public class Principal {

    public static void main( String[] args ) {
        Pilha<Object> m = new Pilha<Object>( Object.class );
        
        m.push( null );
        m.push( 3 );
        m.push( 13 );
        m.push( 2 );
        
        for( Object x : m )
            System.out.println( x );
        
        // Equivalencia
        for( Iterator<Object> itr = m.iterator();
                itr.hasNext(); ) {   
            Object x = itr.next();
            
            System.out.println( x );
        }
    }

}
