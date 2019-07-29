package aula2;
public class Compara��odeStrings {

	public static void main(String[] args) {
        String a = "aa", b = "aa";

        a += "!";
        b += "!";

        System.out.println( "[" + a + "] [" + b + "]" );

        // N�o se compara Strings assim: isso � compara��o de endere�os.
        if( a == b )
            System.out.println( "'a' � igual a 'b'" );
        else
            System.out.println( "'a' � diferente de 'b'" );
        
        // Compara��o correta: usa o m�todo String.equals
        if( a.equals( b ) )
            System.out.println( "'a' � igual a 'b'" );
        else
            System.out.println( "'a' � diferente de 'b'" );
        // A nota��o a.equals( b ) seria equivalente a
        // String.equals( a, b )
        // Ou seja, a vari�vel 'a' � passada como par�metro
        // implicitamente.
	}

}
