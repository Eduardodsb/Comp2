package aula7;
import java.lang.reflect.Array;
import java.util.Iterator;
//Pilha.Java precisa implementar a interface Iterable. Para isso é necessário criar uma classe Iterator (que pode ser interna ou estar em um outro arquivo).
public class Pilha<T> implements Iterable<T> {

    private T[] tab;
    private int topo;
    private Class<T> classe;

    @SuppressWarnings( "unchecked" )
    public Pilha( Class<T> classe ) {
        tab = (T[]) Array.newInstance( classe, 1 );
        this.topo = 0;
        this.classe = classe;
    }

    /**
     * Insere um elemento no final do array (como se fosse uma pilha)
     * 
     * @param valor
     *            o valor a ser inserido.
     */
    public void push( T valor ) {
        if( topo >= tab.length ) 
          expande();
        
        tab[topo++] = valor;
    }
    
    private void expande() {
        @SuppressWarnings( "unchecked" )
        T[] novo = (T[]) Array.newInstance( classe, 2 * tab.length );

        for( int i = 0; i < tab.length; i++ )
            novo[i] = tab[i];
        
        tab = novo;
    }

    public T pop() {
        return tab[--topo];
    }

    public static class IteradorPilha<T> implements Iterator<T> {

        Pilha<T> p;
        int i;
        
        IteradorPilha( Pilha<T> p ) {
            this.p = p;
            this.i = 0;
        }
        
        @Override
        public boolean hasNext() {
            return i < p.topo ? true : false;
        }

        @Override
        public T next() {
            return p.tab[i++];
        }
        
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Pilha.IteradorPilha<T>( this );
    }
}