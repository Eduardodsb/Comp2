package Tarefa6;

public class SortedMap< K extends Comparable<K> ,  V  extends Comparable<V> > {

	    public static class Pair {
	        // Transformando o map em String => Integer
	        public Object key;
	        public Object value;
	    }

	    Pair[] m;
	    

	    public SortedMap() {      
	        m = new Pair[2];

	        for( int i = 0; i < m.length; i++ )
	            m[i] = new Pair();
	    }

	    /**
	     * 
	     * @param key
	     *            A chave que vai ser inserida. Não pode ser null.
	     * @param value
	     *            O valor a ser associado a esta chave
	     */
	    public void put( K key, V value ) {
	        int posicao = find(key);

	        if( posicao == -1 ) {
	            posicao = makeRoom(key);
	            m[posicao].key = key;
	        }

	        m[posicao].value = value;
	    }

		private int find( K key) {
	    	for( int i = 0; i < m.length; i++ )
	            if( key.equals( m[i].key ) )
	                return i;

	        return -1;
	    }

	    /**
	     * Encontra uma chave null. Se for preciso, expande o array m.
	     * 
	     * @return
	     */
	    private int makeRoom(K key) {
	  
	    	if( m[0].key == null ){
	    		return 0;
	    	}else if(m[m.length-1].key == null){ 
	          	int posicao = buscaBinaria(key, 0, m.length-1);
	          	if(m[posicao]!=null)
	          		abrirEspaco(posicao);
	    		return posicao;
	        }
	        expand();
	        return makeRoom(key);
	        // ou return m.length - 1;
	    }
	    
	    @SuppressWarnings("unchecked")
		private int buscaBinaria(K key, int begin, int end){
	    	
	    	int i = (begin + end) / 2;
	    	
	    	if(m[i+1].key == null && i-1 < 0 ){
	    		if((((K)m[i].key).compareTo(key) < 0)){
		    		return i+1;
		    		}else{
		    			return i;
		    		}
	        }
	    	
	    	if(m[i+1].key != null){
	    		if( (((K)m[i].key).compareTo(key) < 0) && (((K)m[++i].key).compareTo(key) > 0))
	    			return i;
	        }
	    	
	    	if(m[i].key == null && m[i-1].key != null){
	    		return i;
	    	}
	    	if(m[i].key == null && m[i-1].key == null){
	    		return buscaBinaria( key, begin, i - 1 );
	    	}
	    		    	
	         // Não foi encontrado
	        else if( ((K)m[i].key).compareTo(key) < 0 )
	            return buscaBinaria( key, i + 1, end );
	        else
	            return buscaBinaria( key, begin, i - 1 );
	    	
	    	/*int i = (begin + end) / 2;
	    	
	    	if(m[i+1].key == null && i-1 < 0 ){
	    		if((((K)m[i].key).compareTo(key) < 0)){
	    		return i+1;
	    		}else{
	    			return i;
	    		}
	    	}
	        if( (((K)m[i].key).compareTo(key) < 0) && (((K)m[++i].key).compareTo(key) > 0)){
	        	return i;
	        }
	        if( begin >= end )
	            return -1; // Não foi encontrado
	        else if( ((K)m[i].key).compareTo(key) < 0 )
	            return buscaBinaria( key, i + 1, end );
	        else
	            return buscaBinaria( key, begin, i - 1 );*/
	    }
	    
	    private void abrirEspaco(int posicao){
	    	Pair[] temp = new Pair[m.length];

	    	for( int i = 0; i < m.length; i++ )
	    		temp[i] = m[i];
	    	int j = 0;
	    	for(int i = 0; i < m.length; i++){
	    		if(i == posicao){
	    			m[i] = null;
	    			m[i] = new Pair();
	    			if(i != m.length-1){
	    				m[++i] = temp[j];
	    				j++;
	    			}
	    		}else{
	    			m[i] = temp[j];
	    			j++;
	    		}
	    		
	    	}
	    }
	    
	    /**
	     * Expande o array m.
	     */
	    private void expand() {
	        Pair[] novo = new Pair[2 * m.length];

	        for( int i = 0; i < m.length; i++ )
	            novo[i] = m[i];

	        for( int i = m.length; i < novo.length; i++ )
	            novo[i] = new Pair();

	        m = novo;
	    }

	    /**
	     * Retorna o valor associado a uma chave.
	     * 
	     * @param key
	     *            a chave
	     * @return o valor associado, ou null.
	     */
	    @SuppressWarnings( "unchecked" )
	    public V get( K key ) {
	        int posicao = find( key );

	        return posicao == -1 ? null : (V) m[posicao].value;
	    }

	    /**
	     * Retorna o número de chaves não nulas no map
	     * 
	     * @return o número de chaves.
	     */
	    public int getNumKeys() {
	        int numKeys = 0;

	        for( int i = 0; i < m.length; i++ )
	            if( m[i].key != null )
	                numKeys++;

	        return numKeys;
	    }

	    /**
	     * Remove uma chave e o seu valor do Map. Se não encontrar, não faz nada.
	     * 
	     * @param key
	     *            A chave do valor a ser removido
	     */
	    public void remove( K key ) {
	        int posicao = find( key );

	        if( posicao != -1 ) {
	            m[posicao].key = null;
	            m[posicao].value = null;
	            removerBuraco(posicao);
	        }
	    }
	    
	    private void removerBuraco(int posicao){
	    	for(int i = posicao; i < m.length-1; i++){
	    			m[i].key = m[i+1].key;
	    			m[i].value = m[i+1].value;
	    			m[i+1].key = null;
	    			m[i+1].value = null;
	    	}
	    }
	    
	    /**
	     * Retorna um array contendo todas as chaves no map.
	     * 
	     * @return o array de chaves.
	     */
	    @SuppressWarnings( "unchecked" )
	    public Vector<K> keys() {
	        Vector<K> keySet = new Vector<K>(getNumKeys());

	        for( int i = 0, j = 0; i < m.length; i++ )
	            if( m[i].key != null )
	                keySet.put(j++, (K) m[i].key );

	        return keySet;
	    }

	    public String toString(){
			String text = "{";
			
			for(int i = 0; i < m.length; i++)
			{
				if(i == 0)
					text += "" + m[i].key + ":" + m[i].value;
				else
					text += ", " + m[i].key + ":" + m[i].value;
			}
			
			text += "}";
			
			return text; 
		}
}

