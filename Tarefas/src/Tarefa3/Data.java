package Tarefa3;
public class Data {
	int dia, mes, ano;
	
	public void setData(int dia, int mes, int ano) throws Exception{
		if(verificaData(dia,mes,ano)){
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}else{
			throw new Exception("Data inválida");
		}
		
	}
	
	public boolean verificaData(int dia, int mes, int ano){
		boolean vAno = verificaAno(ano);
		boolean bi = bissexto(ano);
	    boolean vMes = verificaMes(mes);
	    boolean vDia = verificaDia(dia, mes, bi);
	    
	    return (vAno && vMes && vDia) ? true: false;
	}
	
	public boolean verificaAno(int ano){
		return (ano != 0) ? true : false;
	}
	
	public boolean bissexto(int ano){
		return ((ano % 4 == 0 && ano % 100 == 0 && ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)) ? true : false;
	}
	
	public boolean verificaMes(int mes){
		return mes>=1 && mes<=12 ? true : false;
	}
	
	public boolean verificaDia(int dia, int mes, boolean bi){
		if((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia>=1 && dia<=30)){
			return true;
		}
		if((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia>=1 && dia<=31)){
			return true;
		}
		if(mes == 2 && bi && dia>=1 && dia<=29){
			return true;
		}
		if(mes == 2 && bi == false && dia>=1 && dia<=28){
			return true;
		}
		return false;
	}
	
	public String toString(){
		String Data = dia+"/"+mes+"/"+ano;
		return Data;
	}
	
	public boolean verificaData(){
		return verificaData(dia,mes,ano)?true:false;
	}

}
