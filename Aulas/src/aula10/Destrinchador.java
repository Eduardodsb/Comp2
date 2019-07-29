package aula10;

public class Destrinchador {
	int a;
	public void destrincha( Object o ) {
        Class<?> c = o.getClass();
        
        System.out.println( "Nome: " + c.getName() );
    }
}
