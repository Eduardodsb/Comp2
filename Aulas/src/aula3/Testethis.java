package aula3;

public class Testethis {
    public static void main( String argc[] ) throws Exception {
        Data2 d = new Data2();
        d.setData(17, 10, 2017 );
        System.out.println( d ); //Como existe a função toString em Data2 ele automaticamente chama ela na impressão. O nome da função só pode ser esse para que isso ocorra.
    }
}
