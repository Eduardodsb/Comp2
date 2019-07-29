package aula3;

public class Data2 {
	private int dia, mes, ano;
	
	public void setData( int dia, int mes, int ano ) {
	        this.dia = dia;
	        this.mes = mes;
	        this.ano = ano;
	}
	
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

}

/*
Ele é equivalente ao programa em C abaixo, usando struct.

struct Data {
  int dia, mes, ano;
};
// Em java o parâmetro this é implícito!
void setData( Data *this, int dia, int mes, int ano ) {
  this->dia = dia;
  this->mes = mes;
  this->ano = ano;
}

void main() {
  Data *d = (Data *) malloc( sizeof( Data ) );
  
  setData->( d, 12, 3, 2017 ); // d.setData( 1, 1, 2017 ) está passando o parâmetro "d" implicitamente.
}
*/