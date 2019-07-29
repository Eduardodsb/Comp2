package Tarefa5;

public class Map {
	Pair[] d;
	
	public Map(){
		incializar(2);
	}
	
	public void put(Object key,  Object value){
		Pair[] temp = d;
		for(int i = 0; i<d.length; i++){
			if(key.equals(d[i].key) == true){
				atribuição(i, key, value);
				return;
			}
		}
		for(int i = 0; i<d.length; i++){
			if(d[i].key == null){
				atribuição(i, key, value);
				return;
			}
		}
		incializar(temp.length*2);
		for(int i = 0; i<temp.length; i++){
			d[i] = temp[i];
		}
		put(key,value);
		
	}
	
	public Object get(Object key){
		for(int i = 0; i<d.length; i++){
			if(key.equals(d[i].key) == true){
				return d[i].value;
			}
		}
		return null;
	}
	
	public void remove(Object key){
		for(int i = 0; i<d.length; i++){
			if(key.equals(d[i].key) == true){
				atribuição(i, null, null);
			}
		}
	}
	
	public Object[] keys(){
		Object[] temp;
		int cont = 0;
		int cont2 = 0;
		for(int i=0; i<d.length; i++){
			if(d[i].key != null){
				cont++;
			}
		}

		temp = new Object[cont];
		for(int i=0; i<d.length; i++){
			if(d[i].key != null){
				temp[i-cont2] = d[i].key;
			}else{
				cont2++;
			}
		}
		return temp;
	}
	
	private void incializar(int size) {
		d = new Pair[size];
		for(int i = 0; i<d.length; i++){
			d[i] = new Pair();
		}
	}
	
	private void atribuição(int i, Object key, Object value){
		d[i].key = key;
		d[i].value = value;
	}
	
	public static class Pair{
		Object key, value;
	}

}
