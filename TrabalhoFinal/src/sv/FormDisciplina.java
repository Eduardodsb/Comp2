package sv;

public class FormDisciplina {
	private int id = -1;
    private String nome = "";

    public String getNome() {
        return nome;
    }

    @Campo( obrigatorio = true ) 
    public void setNome( String nome ) {
        this.nome = (nome == null ? "" : nome);
    }

      @Override
    public String toString() {
        return getNome();
    }
    
    public static void main( String[] args ) {
        System.out.println( new FormAluno().getClass().getCanonicalName() );
    }

    public void setID( String valor ) {
        id = Integer.valueOf( valor );
    }
    
    public int getID() {
        return id;
    }
}
