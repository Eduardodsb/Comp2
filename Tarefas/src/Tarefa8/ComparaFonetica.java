package Tarefa8;
import java.util.*;

public class ComparaFonetica {

	private TreeMap<String, String> eq = new TreeMap<String, String>();
 
	public void put(String key, String value){
		eq.put(key, value);
		eq.put(value, key);	
	}
	
	public boolean equivalente(String string_1, String string_2){
		if(string_1.compareToIgnoreCase(string_2) == 0)
			return true;
	    if(compareStrings(string_1, string_2))
	    	return true;
	    if(compareStrings(string_2, string_1))
	    	return true;
	    
	    return false;
	}
	
	private boolean compareStrings(String s1, String s2){
		String temp = "";
	    for(String a: eq.keySet()){
	    	if(s1.contains(a) && s2.contains(eq.get(a))){
	    		temp = ""+s1;
	    		temp = temp.replaceAll(a, eq.get(a));
	    		if(temp.compareToIgnoreCase(s2) == 0){
	    			return true;
	    		}
	    	}
	    }
	    return false;
	}	
 
}
