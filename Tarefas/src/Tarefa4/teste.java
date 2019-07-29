package Tarefa4;

public class teste {

	public static void main(String[] args)throws Exception {
	      StringVector v = new StringVector(10);
	      v.put( 1, "Janeiro");
	      v.put( 2, "fevereiro" );
	      v.put( 4, "Mar�o");
	      v.put( 6, "Abril" );
	      
	      v.print();//Mostrar como ficou o vetor
	      System.out.println("______________________");
	      
	      System.out.println( v.at( 4 ) );//imprime quem est� na posi��o 4
	      //System.out.println( v.at( 13 ) ); // Exce��o ArrayIndexOutOfBoundsException

	      v.newSize( 4 ); // Redimesiona o vetor
	      
	      System.out.println("______________________");
	      v.print(); // Mostrar como ficou ap�s ser redimensionado.
	      System.out.println("______________________");
	      
	      System.out.println( v.find("Abril") );//Retorna a poisi��o em que abril se encontra no vetor
	      System.out.println( v.find("Comp2") );//Retorna -1 por comp2 n�o existir no vetor
	      System.out.println( v.at(3) ); //imprime quem est� na posi��o 3
	      //v.newSize( 1 ); // Exce��o VectorSizeException

	}
}
    