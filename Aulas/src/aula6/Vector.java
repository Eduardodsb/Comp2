package aula6;

public class Vector<T> {

    private Object o[];

    public Vector( int size ) {
        o = new Object[size];
    }

    public void resize( int newSize ) {
        Object novo[] = new Object[newSize];

        for( int i = 0; i < o.length; i++ )
            novo[i] = o[i];
    }

    public void put( int i, T value ) {
        o[i] = value;
    }

    @SuppressWarnings( "unchecked" )
    public T at( int i ) {
        return (T) o[i];
    }

    public String toString() {
        String aux = "[";

        for( int i = 0; i < o.length - 1; i++ )
            aux += o[i] + ",";

        if( o.length > 0 )
            aux += o[o.length - 1];

        return aux + "]";
    }

    public int find( T value ) {
        for( int i = 0; i < o.length; i++ )
            if( o[i].equals( value ) )
                return i;

        return -1;
    }
    
    

    public int size() {
        return o.length;
    }
}
