package sv;

public class CampoNaoPreenchidoException extends Exception {

    public CampoNaoPreenchidoException( String nomeParam ) {
        super( "O campo " + nomeParam + " � obrigat�rio." );
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
