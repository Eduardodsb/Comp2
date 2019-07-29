package aula2;

public class Vetores {
	
	//Vetores em Java não podem ter o tamanho indicado na declaração, apenas na atribuição.
	public static void main(String[] args) {
		int [] tab = {10, 20, 30};
		
		for(int i = 0; i<3; i++){
			System.out.println(tab[i]);
		}
		
        // Automaticamente verifica os limites de array e dá Exceção
        System.out.println( tab[3] );
	}
	//O Java sempre verifica se o acesso aos elementos do vetor está respeitando os limites do mesmo.
}
