package aula7;

public class InicializacaoSimples {
    public String str = "Valor default";

    // A inicializa��o da vari�vel feita acima � realizada antes de chamar o construtor ( qualquer construtor).
    InicializacaoSimples() {
    }

    public static void main( String[] args ) {
        InicializacaoSimples is = new InicializacaoSimples();

        System.out.println( is.str );
    }
}
