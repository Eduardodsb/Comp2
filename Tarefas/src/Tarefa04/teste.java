package Tarefa04;

public class teste {

	public static void main(String[] args) {
	      StringVector v = new StringVector(10);
	      v.put( 0, "Janeiro");
	      v.put( 2, "fevereiro" );
	      v.put( 3, "Mar�o");
	      v.put( 4, "Abril" );
	      
	      System.out.println( v.find("mar�o") );
	      v.newSize(15);
	      v.newSize(7);
	      
	      
	      v.put( 5, "junho ");
	      v.put( 6, "agosto" );
	      
	      System.out.println( v.at( 3 ) );

	      System.out.println( v.at( 1 ) ); // Exce��o
/*
	      v.newSize( 2 ); // OK
	      v.newSize( 1 ); // Exce��o*/
	      
	      System.out.println( v.find("Mar�o") );
	      System.out.println( v.at( 5 ) ); 

	}

}
