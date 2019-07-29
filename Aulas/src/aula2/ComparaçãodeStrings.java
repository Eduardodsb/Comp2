package aula2;
public class ComparaçãodeStrings {

	public static void main(String[] args) {
        String a = "aa", b = "aa";

        a += "!";
        b += "!";

        System.out.println( "[" + a + "] [" + b + "]" );

        // Não se compara Strings assim: isso é comparação de endereços.
        if( a == b )
            System.out.println( "'a' é igual a 'b'" );
        else
            System.out.println( "'a' é diferente de 'b'" );
        
        // Comparação correta: usa o método String.equals
        if( a.equals( b ) )
            System.out.println( "'a' é igual a 'b'" );
        else
            System.out.println( "'a' é diferente de 'b'" );
        // A notação a.equals( b ) seria equivalente a
        // String.equals( a, b )
        // Ou seja, a variável 'a' é passada como parâmetro
        // implicitamente.
	}

}
