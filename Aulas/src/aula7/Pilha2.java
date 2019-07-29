package aula7;

import java.lang.reflect.Array;
//Ao usar generics, uma técnica básica é armazenar a classe do objeto base de uma array. Isso pode ser feito obrigando o construtor a receber esse parâmetro classe
public class Pilha2<T> {

    private T[] tab;
    private int topo;
    private Class<T> classe;

    @SuppressWarnings( "unchecked" )
    public Pilha2( Class<T> classe ) {
        tab = (T[]) Array.newInstance( classe, 1 );
        this.topo = 0;
        this.classe = classe;
    }

    /**
     * Insere um elemento no final do array (como se fosse uma pilha)
     * 
     * @param valor
     *            o valor a ser inserido.
     */
    public void push( T valor ) {
        if( topo >= tab.length ) 
          expande();
        
        tab[topo++] = valor;
    }
    
    private void expande() {
        @SuppressWarnings( "unchecked" )
        T[] novo = (T[]) Array.newInstance( classe, 2 * tab.length );

        for( int i = 0; i < tab.length; i++ )
            novo[i] = tab[i];
        
        tab = novo;
    }

    public T pop() {
        return tab[--topo];
    }

}
