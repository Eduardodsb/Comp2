package aula10;

import java.util.ArrayList;

public class getClass {
    public static void main( String[] argc ) {
        Destrinchador destr = new Destrinchador();
        destr.destrincha( new String() );
        destr.destrincha( new String[2][2][9] );
        
        ClasseDestrinchador destr2 = new ClasseDestrinchador(5);
        destr2.destrincha(new String());

    }
}
