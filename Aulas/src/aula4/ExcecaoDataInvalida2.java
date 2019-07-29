package aula4;

public class ExcecaoDataInvalida2 extends Exception {

    private static final long serialVersionUID = 1L;
    
    private int dia;
    private int mes;
    private int ano; 
    
    public String toString() {
        return dia + "/" + mes + "/" + ano; 
    }

    // Construtor - método que só tem o nome da classe.
    public ExcecaoDataInvalida2( int dia, int mes, int ano ) {
      this.dia = dia;
      this.mes = mes;
      this.ano = ano;
    }

}


