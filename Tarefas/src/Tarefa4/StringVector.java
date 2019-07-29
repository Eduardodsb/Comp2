package Tarefa4;

public class StringVector {
	String[] vetor;
	int a;
	
	public StringVector(int size){
		inicializarEZerarVetor(size);
	}

	public void newSize(int newSize)throws VectorSizeException{
		String[] temp = new String[vetor.length];
		temp = vetor;
		
		if(newSize > vetor.length){
			inicializarEZerarVetor(newSize);
            for(int i = 0; i < temp.length; i++)
                vetor[i] = temp[i];
        }else{
        	if(possibilidadeDeRedução(newSize)){
            	inicializarEZerarVetor(newSize);
                int cont = 0;
                for(int i = 0; i < temp.length; i++){
                	for(int j=cont; j < temp.length; j++){
                		if(temp[j] != ""){
                			vetor[i] = temp[j];
                			cont++;
                			break;
                		}else{
                			cont++;
                		}
                	}
                }
            }else{
            	throw new VectorSizeException();
            }
        }
	}
	
	public String at(int i){
		verificarLimites(i);
		return vetor[i];
	}
	
	public void put(int i, String st){
		verificarLimites(i);
		vetor[i] = st;
	}

	public int find(String st){
		for(int i=0; i<vetor.length; i++)
			if(st.compareToIgnoreCase(vetor[i]) == 0)
				return i;
		return -1;
	}
	
	public void inicializarEZerarVetor(int size){
		vetor = new String[size];
        for(int i = 0; i < size; i++)
            vetor[i] = "";
	}
	
	public boolean possibilidadeDeRedução(int newSize){
        int contVazio = 0;
        for(int i = 0; i<vetor.length; i++){
            if(vetor[i] == "")
                contVazio++;
        }
        if(contVazio >= vetor.length - newSize)
        	return true;
        return false;
	}
	
	public void verificarLimites(int i) throws ArrayIndexOutOfBoundsException{
		if(i > vetor.length)
			 throw new ArrayIndexOutOfBoundsException("Limite do vetor ultrapassado");
	}
	
	public void print(){
		for(int i = 0; i < vetor.length; i++)
            System.out.println(vetor[i]);
	}

}
