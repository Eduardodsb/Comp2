package aula2;

public class Vetores2 {
	//A inicialização pode ser por alocação, dizendo apenas o tamanho. Nesse caso o vetor é inicializado com zeros (ou equivalente).
	public static void main(String[] args) {
		int[] tab = new int[5];
		
		for(int i = 0; i<5; i++){
			tab[i] = i*i;
			
			System.out.println(tab[i]);
		}
		
		tab = new int[3];
        // É outro vetor, e agora, zerado.
        
        for( int i = 0; i < 3; i++ ) 
            System.out.println( tab[i] );

	}

}
