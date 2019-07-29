package sv;

public class Disciplina {
	 private int id = -1;
	    private String nome = "";

	    public String getNome() {
	        return nome;
	    }

	    public void setNome( String nome ) {
	        this.nome = (nome == null ? "" : nome);
	    }
	        
	    public void setID( String valor ) {
	        id = Integer.valueOf( valor );
	    }
	    
	    public int getID() {
	        return id;
	    }
}
