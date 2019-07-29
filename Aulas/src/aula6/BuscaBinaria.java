package aula6;

public class BuscaBinaria {
	 public static <T extends Comparable<T>> int pesquisaBinaria( T key, T v[], int begin, int end ) {
	        int i = (begin + end) / 2;

	        if( v[i] == key )
	            return i;
	        if( begin >= end )
	            return -1; // Não foi encontrado
	        else if( v[i].compareTo( key ) < 0 )
	            return pesquisaBinaria( key, v, i + 1, end );
	        else
	            return pesquisaBinaria( key, v, begin, i - 1 );
	    }
}
