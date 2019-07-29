package sv;

// FormAluno: uma classe POJO para armazenar os par�metros para as atividades
// relacionadas a Aluno. Tamb�m chamada de AlunoVO (Value Object)
public class FormAluno {

    private int id = -1;
    private String nome = "";
    private String celular = "";
    private String email = "";

    /**
     * O nome do aluno. N�o pode ser deixado em branco.
     * 
     * @return retorna o nome, ou null.
     */
    public String getNome() {
        return nome;
    }

    @Campo( obrigatorio = true ) 
    public void setNome( String nome ) {
        this.nome = (nome == null ? "" : nome);
    }

    public String getCelular() {
        return celular;
    }

    @Campo( obrigatorio = true ) 
    public void setCelular( String celular ) {
        this.celular = (celular == null ? "" : celular);
    }

    public String getEmail() {
        return email;
    }

    @Campo( obrigatorio = false ) 
    public void setEmail( String email ) {
        this.email = (email == null ? "" : email);
    }
    
    @Override
    public String toString() {
        return getNome() + "/" + getCelular() + "/" + getEmail();
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
