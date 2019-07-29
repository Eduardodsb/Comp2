package aula3;
//Exceções não são Erros!!
//São situações que fogem às regras ou especificações, ou seja, fora da normalidade. Muitos erros são exceções, mas nem todos. E muitas exceções são erros, mas nem todas.

public class SinalizandoExceções {
	
	// Cada função que pode lançar uma uma exceção deve indicar
    // esse fato no cabeçalho através da declaração throws.

	public static void main(String[] args) throws Exception {
		 Data d = null;

	        if( d == null )
	            throw new Exception( "D é null" );
	            // Usamos o throw para sinalizar uma Exceção.
	            // Uma exceção pode ter uma mensagem de erro.
	        
	        d.setAno( 2017 );
	        d.setMes( 17 );
	        d.setDia( 10 );

	        System.out.println( d.getDia() + "/" + d.getMes() + "/" + d.getAno() );
	}

}
