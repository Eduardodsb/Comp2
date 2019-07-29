package aula10;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class invoke {
	public static void main( String[] argc ) {
        String st = "Exemplo de Introspecção" ;
        String nomeDoMetodo = "replace";
        Object args[] = { "e", "X" };
        
        Method metodos[] = st.getClass().getDeclaredMethods();
        
        for( Method m : metodos ) 
            if( m.getName().equals( nomeDoMetodo ) )
                try {
                    System.out.println( m.invoke( st, args ) );
                } catch( IllegalAccessException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch( IllegalArgumentException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch( InvocationTargetException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        
    }
}
