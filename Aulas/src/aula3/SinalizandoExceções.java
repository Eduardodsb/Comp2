package aula3;
//Exce��es n�o s�o Erros!!
//S�o situa��es que fogem �s regras ou especifica��es, ou seja, fora da normalidade. Muitos erros s�o exce��es, mas nem todos. E muitas exce��es s�o erros, mas nem todas.

public class SinalizandoExce��es {
	
	// Cada fun��o que pode lan�ar uma uma exce��o deve indicar
    // esse fato no cabe�alho atrav�s da declara��o throws.

	public static void main(String[] args) throws Exception {
		 Data d = null;

	        if( d == null )
	            throw new Exception( "D � null" );
	            // Usamos o throw para sinalizar uma Exce��o.
	            // Uma exce��o pode ter uma mensagem de erro.
	        
	        d.setAno( 2017 );
	        d.setMes( 17 );
	        d.setDia( 10 );

	        System.out.println( d.getDia() + "/" + d.getMes() + "/" + d.getAno() );
	}

}
