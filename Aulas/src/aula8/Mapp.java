package aula8;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Mapp {
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
    }
}
