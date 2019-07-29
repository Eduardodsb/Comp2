package Tarefa9;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class Principal{

    public static void main( String[] args ){
    	Map<String, Integer> palavras = new LinkedHashMap<String, Integer>();
        Path wiki_path = Paths.get( "C:\\Users\\eduar\\workspace\\Tarefas\\src\\Tarefa9", "entrada.txt" );
        Charset charset = Charset.forName( "ISO-8859-1" );
        try {
            List<String> lines = Files.readAllLines( wiki_path, charset );

            for( String line : lines ) {
                String p[] = line.split( "[  ,;.()]+" );
                for(int i=0; i<p.length; i++){
                	p[i] = p[i].toLowerCase();
                	if(!palavras.containsKey(p[i])){
                		palavras.put(p[i],1);
                	}else{
                		palavras.put(p[i],palavras.get(p[i])+1);
                	}
                }
            }
            
            ordena(palavras);
 
            System.out.println(palavras);
 
        } catch( IOException e ) {
            System.out.println( e );
        }

    }


	public static void ordena(Map<String, Integer> palavras){
    	String key[];
    	int value[];
		key =  new String[palavras.size()];
        value = new int[palavras.size()];
        int cont = 0;
        
        for(String a: palavras.keySet()){
        	key[cont] = a;
        	value[cont] = palavras.get(a);
        	cont++;
        }
        
       int tempValue;
       String tempKey;
       for(int i=0; i<value.length; i++){
    	   for(int j=0; j<value.length-1; j++){
    		   if(value[j] < value[j+1]){
    			   
    			   tempValue = value[j+1];
    			   value[j+1] = value[j];
    			   value[j] = tempValue;
    			   
    			   tempKey = key[j+1];
    			   key[j+1] = key[j];
    			   key[j] = tempKey;
    			   
                    }
                }
            }
       
       palavras.clear();
       
       for(int i = 0; i < value.length; i++){
    	   palavras.put(key[i],value[i]);
       }
	}
}