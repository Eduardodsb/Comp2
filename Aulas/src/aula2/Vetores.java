package aula2;

public class Vetores {
	
	//Vetores em Java n�o podem ter o tamanho indicado na declara��o, apenas na atribui��o.
	public static void main(String[] args) {
		int [] tab = {10, 20, 30};
		
		for(int i = 0; i<3; i++){
			System.out.println(tab[i]);
		}
		
        // Automaticamente verifica os limites de array e d� Exce��o
        System.out.println( tab[3] );
	}
	//O Java sempre verifica se o acesso aos elementos do vetor est� respeitando os limites do mesmo.
}
