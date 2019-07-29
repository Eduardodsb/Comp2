package Tarefa2;
public class Tarefa02{
  
	public static void main(String[] args)  {
	String[] tab = new String[] { "z", "g", "a", "k", "ff", "w", "wz", "wa" };
		print(tab);
        ordenar(tab);
    	System.out.println("\n");
    	print(tab);
  }
 
  public static void ordenar(String[] letras){
        String temp;
        for(int i=0; i<letras.length; i++){
            for(int j=0; j<letras.length-1; j++){
                if(letras[j].compareTo(letras[j+1])> 0){
                    temp = letras[j+1];
                    letras[j+1] = letras[j];
                    letras[j] = temp;
                }
            }
        }
    }

  public static void print(String[] tab){
  	for(int i = 0; i<tab.length; i++){
        System.out.print(tab[i]+ ", ");
  	}
  	System.out.println();
  }

}