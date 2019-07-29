package Tarefa04;

public class StringVector {
	String[] vetor;
	int a;
	
	public StringVector(int size){
		vetor = new String[size];
        for(int i = 0; i < size; i++){
            vetor[i] = "";
        }
	}

	public void newSize(int newSize){
		String[] temp = new String[vetor.length];
		temp = vetor;
		vetor = new String[newSize];
		
		if(newSize > temp.length){
            for(int i = 0; i < newSize; i++){
                vetor[i] = "";
            }
            for(int i = 0; i < temp.length; i++){
                vetor[i] = temp[i];
            }
            print();
        }else{
            int contVazio = 0;
            for(int i = 0; i<temp.length; i++){
                if(temp[i] == ""){
                    contVazio++;
                }
            }
            if(contVazio >= temp.length - newSize){
                for(int i = 0; i < newSize; i++){
                    vetor[i] = "";
                }
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
            	print();
            }else{
            	//exceção
            }
        }
	}
	
	public String at(int i){
		return vetor[i];
	}
	
	public void put(int i, String st){
		vetor[i] = st;
	}

	public int find(String st){
		for(int i=0; i<vetor.length; i++){
			if(st.compareToIgnoreCase(vetor[i]) == 0){
				return i;
			}
		}
		return -1;
	}
	public void print(){
        for(int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
           
        }
	}
}
