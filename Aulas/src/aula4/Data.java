package aula4;

public class Data {

    private int dia, mes, ano;

    public void setData( int dia, int mes, int ano ) throws ExcecaoDataInvalida2  {
        if( !isValid( dia, mes, ano ) )
        	throw new ExcecaoDataInvalida2(dia,mes,ano);

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    private static boolean isValid( int dia, int mes, int ano ) {
        return ano > 0 && mes > 0 && mes <= 12 && dia > 0 
                && dia <= numeroDeDiasNesseMes( mes, ano );
    }
    
    private static int numeroDeDiasNesseMes( int mes, int ano ) {
        switch( mes ) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;

            case 2:
                boolean bissexto = ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0);

                if( bissexto )
                    return 29;
                else
                    return 28;
            default:
                return 31;
        }
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public boolean isValid() {
        return isValid( dia, mes, ano );
    }
}
