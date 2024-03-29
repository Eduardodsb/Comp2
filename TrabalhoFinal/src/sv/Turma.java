package sv;

public class Turma {

    private int id = -1;
    private String nome = "";
    private String professor = "";
    private String disciplina = "";

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = (nome == null ? "" : nome);
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor( String professor ) {
        this.professor = (professor == null ? "" : professor);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina( String disciplina ) {
        this.disciplina = (disciplina == null ? "" : disciplina);
    }
    
    public String toString() {
        return getNome() + "/" + getDisciplina() + "/" + getProfessor();
    }
    
    public void setID( String valor ) {
        id = Integer.valueOf( valor );
    }
    
    public int getID() {
        return id;
    }
}
