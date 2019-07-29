package aula3;

public class Data {
    // Atributos private: não podem ser alterados fora desse
    // arquivo (classe)
	
	private int dia, mes, ano;
	public int getDia() {
        return dia;
    }

    public void setDia( int dia ) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes( int mes ) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno( int ano ) {
        this.ano = ano;
    }
}