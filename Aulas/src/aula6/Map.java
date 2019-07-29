package aula6;

//Generics: construção que permite passar um tipo como parâmetro
//Pode ser usado para Classes e para métodos.
public class Map< Tipo_Key, Tipo_Value > {

 public static class Pair {
     // Transformando o map em String => Integer
     public Object key;
     public Object value;
 }

 Pair[] m;

 public Map() {      
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
 public void put( Tipo_Key key, Tipo_Value value ) {
     int posicao = find( key );

     if( posicao == -1 ) {
         posicao = makeRoom();
         m[posicao].key = key;
     }

     m[posicao].value = value;
 }

 private int find( Tipo_Key key ) {
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
 @SuppressWarnings( "unchecked" )
 public Tipo_Value get( Tipo_Key key ) {
     int posicao = find( key );

     return posicao == -1 ? null : (Tipo_Value) m[posicao].value;
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
 public void remove( Tipo_Key key ) {
     int posicao = find( key );

     if( posicao != -1 ) {
         m[posicao].key = null;
         m[posicao].value = null;
     }
 }
 // PesquisaBinaria
 public static <T extends Comparable<T>> int pesquisaBinaria( T key, T v[], int begin, int end ) {
     int i = (begin + end) / 2;

     if( v[i] == key )
         return i;
     if( begin >= end )
         return -1; // Não foi encontrado
     else if( v[i].compareTo( key ) < 0 )
         return pesquisaBinaria( key, v, i + 1, end );
     else
         return pesquisaBinaria( key, v, begin, i - 1 );
 }
 
 /**
  * Retorna um array contendo todas as chaves no map.
  * 
  * @return o array de chaves.
  */
 
 @SuppressWarnings( "unchecked" )
 public Vector<Tipo_Key> keys() {
     Vector<Tipo_Key> keySet = new Vector<Tipo_Key>(getNumKeys());

     for( int i = 0, j = 0; i < m.length; i++ )
         if( m[i].key != null )
             keySet.put(j++, (Tipo_Key) m[i].key );

     return keySet;
 }

}