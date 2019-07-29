package aula2;
//Laboratorio 2 de Comp 2
//programa feito por: Bruno hryniewicz dos Santos Cruz
public class SoluçãoparaTarefa02 {

	public static void main( String[] args ) {
        String[] vetor = new String[] { "z", "g", "a", "k", "ff", "w", "wz", "wa" };
        ordenaPorBolha( vetor );
        imprime( vetor );

    }

    public static void ordenaPorBolha( String[] vetor ) {
        for( int i = vetor.length - 1; i >= 0; i-- )
            for( int j = 0; j < i; j++ )
                ordenaPar( vetor, j );
    }

    public static void ordenaPar( String[] vetor, int j ) {
        if( seguinteMenor( vetor, j ) )
            troca( vetor, j );
    }

    public static boolean seguinteMenor( String[] vetor, int j ) {
        return vetor[j].compareTo( vetor[j + 1] ) > 0;
    }

    public static void troca( String[] vetor, int j ) {
        String aux = vetor[j];
        vetor[j] = vetor[j + 1];
        vetor[j + 1] = aux;
    }

    public static void imprime( String[] vetor ) {
        for( int i = 0; i < vetor.length; i++ ) {
            System.out.print( vetor[i] + " " );
        }
    }

}
