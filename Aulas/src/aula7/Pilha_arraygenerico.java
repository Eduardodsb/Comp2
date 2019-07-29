package aula7;
import java.lang.reflect.Array;
//É possível criar um array genérico sabendo a sua classe. Para isso devemos usar o pacote java.lang.reflect.Array.
public class Pilha_arraygenerico<T> {

    private T[] tab;
    private int topo;

    @SuppressWarnings( "unchecked" )
    public Pilha_arraygenerico( Class<T> classe ) {
        tab = (T[]) Array.newInstance( classe, 10 );
        this.topo = 0;
    }

    /**
     * Insere um elemento no final do array (como se fosse uma pilha)
     * 
     * @param valor
     *            o valor a ser inserido.
     */
    public void push( T valor ) {
        tab[topo++] = valor;
    }
}