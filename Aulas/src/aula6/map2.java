package aula6;

public class map2 {

    public static class Pair {
        // Transformando o map em String => Integer
        public String key;
        public Integer value;
    }

    Pair[] m;

    public map2() {
        m = new Pair[2];

        for( int i = 0; i < m.length; i++ )
            m[i] = new Pair();
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
     * 
     * @param key
     *            A chave que vai ser inserida. Não pode ser null.
     * @param value
     *            O valor a ser associado a esta chave
     */
    public void put( String key, Integer value ) {
        int posicao = find( key );

        if( posicao == -1 ) {
            posicao = makeRoom();
            m[posicao].key = key;
        }

        m[posicao].value = value;
    }

    private int find( String key ) {
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
    private int makeRoom() {
        for( int i = 0; i < m.length; i++ )
            if( m[i].key == null )
                return i;

        int posicao = m.length;
        expand();
        return posicao;
        // ou return m.length - 1;
    }

    /**
     * Retorna o valor associado a uma chave.
     * 
     * @param key
     *            a chave
     * @return o valor associado, ou null.
     */
    public Integer get( String key ) {
        int posicao = find( key );

        return posicao == -1 ? null : m[posicao].value;
    }

    /**
     * Retorna um array contendo todas as chaves no map.
     * 
     * @return o array de chaves.
     */
    public String[] keys() {
        String[] keySet = new String[getNumKeys()];

        for( int i = 0, j = 0; i < m.length; i++ )
            if( m[i].key != null )
                keySet[j++] = m[i].key;

        return keySet;
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
    public void remove( String key ) {
        int posicao = find( key );

        if( posicao != -1 ) {
            m[posicao].key = null;
            m[posicao].value = null;
        }
    }

}
