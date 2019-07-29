package Tarefa1;
/*
Computação 2
Nome: Eduardo da Silva Barbosa
DRE: 116150432

1° TAREFA - MDC
*/

public class MDC{
  public static void main(String[] args){
	int n1 = 129, n2 = 51;
    System.out.println("Mdc entre " + n1 + " e " + n2 + ": " + CalMDC(n1,n2));
  }
  
  public static int CalMDC(int n1, int n2){
    return n2 == 0 ? n1 : CalMDC(n2,n1%n2);
  }
}