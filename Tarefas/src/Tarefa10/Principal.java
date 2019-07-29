package Tarefa10;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.io.IOException;

public class Principal {
	public static void main(String[] args){
		String st = "Exemplo de Introspec��o";
		int cont=0;
		Path data_path = Paths.get( "C:\\Users\\eduar\\workspace\\Tarefas\\src\\Tarefa10", "entrada.txt" );
        Charset charset = Charset.forName( "ISO-8859-1" );
        Method[] metodos = st.getClass().getDeclaredMethods();

        try{
        	List<String> lines = Files.readAllLines(data_path, charset);
        	for(String line : lines){
        		String p[] = line.split( "[ ]+" );
        		Object[] argumentos = new Object[p.length-1];
        		
        		for(int i = 1; i < p.length; i++ ){
        			argumentos[i-1] =  p[i]; 
        		}
        		
        		for(int i = 0; i<metodos.length; i++){
        			if((metodos[i].getName()).equals(p[0])){
        				try{
        					Object resultado =  metodos[i].invoke(st, argumentos);
        					System.out.println("O m�todo utilizado foi: "+metodos[i]);
        					System.out.println("O resultado utilizando o m�todo acima �: "+resultado+"\n");
        					break;
        				}catch(IllegalArgumentException e){
        					System.out.println("IllegalArgumentException: O argumento passado como par�metro para o m�todo(" + metodos[i]+")"+" � impr�prio \n" );
        					//e.printStackTrace(); 
        				}catch(IllegalAccessException e){
							System.out.println("IllegalAccessException: N�o foi possivel acessar o m�todo: " + metodos[i]); 
							//e.printStackTrace();
        				}catch(InvocationTargetException e){
        					System.out.println("InvocationTargetException");
        					//e.printStackTrace(); 
        				}
        			}else{
        			cont++;
        			}
        		}
        		if(cont == metodos.length){
        			System.out.println("O met�do ("+p[0]+")" + "n�o foi encontrado na classe : " + st.getClass().getName());
        		}
        		cont = 0;
        	}
        }catch (IOException e){
        	System.out.println( "Arquivo n�o existe" );
        }
	}
}






