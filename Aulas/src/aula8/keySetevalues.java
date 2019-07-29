package aula8;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class keySetevalues {
	 public static void main( String[] args ) {
	        Map<String, Integer> dias = new TreeMap<String, Integer>();

	        dias.put( "Domingo", 1 );
	        dias.put( "Segunda", 2 );
	        dias.put( "Terça", 3 );
	        dias.put( "quarta", 4 );
	        dias.put( "Quinta", 5 );
	        dias.put( "Sexta", 6 );
	        dias.put( "Sábado", 7 );
	        
	        System.out.println( dias );
	        
	        System.out.println( dias.keySet() );
	        System.out.println( dias.values() );
	        
	        List<String> d = new ArrayList<String>();
	        d.addAll( dias.keySet() );
	        d.sort( new Comparator<String>() {
	            @Override
	            public int compare( String o1, String o2 ) {
	                return o1.compareToIgnoreCase( o2 );
	            }
	        } );
	        
	        System.out.println( d );
	    }
}
