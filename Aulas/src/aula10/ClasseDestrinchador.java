package aula10;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
public class ClasseDestrinchador {

	public static int bobao;

    public ClasseDestrinchador( int a ) {
    }

    public void destrincha( Object o ) {
        Class<?> c = o.getClass();

        System.out.println( "=====\nNome: " + c.getName() );
        if( c.getComponentType() == null )
            System.out.println( "  Não é array" );
        else
            System.out.println( "  É um array - base: " + c.getComponentType().getName() );

        for( Constructor<?> ct : c.getDeclaredConstructors() ) {
            System.out.println( "  Construtor: " + ct.getName() );

            for( Parameter p : ct.getParameters() ) {
                System.out.println( "    " + p.getType().getName() );
            }
        }

        for( Field f : c.getDeclaredFields() ) {
            String mod = "";

            mod += Modifier.isStatic( f.getModifiers() ) ? "static " : "";
            mod += Modifier.isPublic( f.getModifiers() ) ? "public " : "";
            mod += Modifier.isPrivate( f.getModifiers() ) ? "private " : "";
            mod += Modifier.isProtected( f.getModifiers() ) ? "protected " : "";

            System.out.println( "  Campo: " + mod + f.getName() );
        }
        
        for( Method m : c.getDeclaredMethods() ) {
            System.out.println( "  Método: " + m.getName() );

            for( Parameter p : m.getParameters() ) 
                System.out.println( "    " + p.getType().getName() );
        }

        System.out.println( "== FIM == \n" );
    }
	
}
