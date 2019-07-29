package aula7;

public class InicializacaoSimples {
    public String str = "Valor default";

    // A inicialização da variável feita acima é realizada antes de chamar o construtor ( qualquer construtor).
    InicializacaoSimples() {
    }

    public static void main( String[] args ) {
        InicializacaoSimples is = new InicializacaoSimples();

        System.out.println( is.str );
    }
}
