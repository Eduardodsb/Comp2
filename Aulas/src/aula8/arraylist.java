package aula8;
import java.util.ArrayList;

public class arraylist {
	
	public static void main( String[] args ) {
        ArrayList<String> dias = new ArrayList<String>();

        dias.add( "Domingo" );
        dias.add( "Segunda" );
        dias.add( "Terça" );

        System.out.println( dias );
        
        dias.remove("Segunda");
        for(String a : dias){
        	System.out.println(a);
        }
    }
}
