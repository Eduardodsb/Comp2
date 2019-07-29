package sv;

public class FormTurma {
	 private int id = -1;
	    private String nome = "";
	    private String professor = "";
	    private String disciplina = "";


	    public String getNome() {
	        return nome;
	    }

	    @Campo( obrigatorio = true ) 
	    public void setNome( String nome ) {
	        this.nome = (nome == null ? "" : nome);
	    }

	    public String getProfessor() {
	        return professor;
	    }

	    @Campo( obrigatorio = true ) 
	    public void setProfessor( String professor ) {
	        this.professor = (professor == null ? "" : professor);
	    }

	    public String getDisciplina() {
	        return disciplina;
	    }

	    @Campo( obrigatorio = true ) 
	    public void setDisciplina( String disciplina ) {
	        this.disciplina = (disciplina == null ? "" : disciplina);
	    }
	    
	    @Override
	    public String toString() {
	        return getNome() + "/" + getProfessor() + "/" + getDisciplina();
	    }
	    
	    public static void main( String[] args ) {
	        System.out.println( new FormTurma().getClass().getCanonicalName() );
	    }

	    public void setID( String valor ) {
	        id = Integer.valueOf( valor );
	    }
	    
	    public int getID() {
	        return id;
	    }
}
