package sv;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import sv.Campo;

public class Cadastro {

    @Acao( form = FormListar.class )
    public String listar( FormListar form ) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println( "Entidade " + form.getEntidade() );

        ArrayList<String> nome = new ArrayList<>();
        Controle Object = (Controle) Class.forName("sv.Cadastro"+form.getEntidade()).newInstance();
        nome = Object.listar(nome);
        form.setNome(nome);
        form.setSize(nome.size());
        return "./WEB-INF/listar.jsp";
    }

    @Acao( form = FormExibir.class )
    public String exibir( FormExibir form ) {
        try {
            Class<?> classeDoCadastro = Class.forName( "sv.Cadastro" + form.getEntidade() );
            Controle controle = (Controle) classeDoCadastro.newInstance();
            Object formEntidade = controle.preencheForm( Integer.valueOf( form.getId() ) );

            Map<String, String> campos = new TreeMap<>();

            for( Method m : formEntidade.getClass().getMethods() )
                if( m.isAnnotationPresent( Campo.class ) ) {
                    String label = m.getName().substring( 3 );

                    campos.put( label, chamaGetter( formEntidade, "get" + label ) );
                }

            form.setCampos( campos );

        } catch( Exception e ) {
            e.printStackTrace();
        }

        if( form.getEditar().equals( "true" ) )
            return "./WEB-INF/editar.jsp";
        else
            return "./WEB-INF/exibir.jsp";

    }
    
    @Acao( form = FormExibir.class )
    public String exibirCadastro(FormExibir form) {
    	try {
            Class<?> classeDoForm = Class.forName("sv.Form" + form.getEntidade());

            Map<String, String> campos = new TreeMap<>();
            
            for( Method m : classeDoForm.getMethods() )
                if( m.isAnnotationPresent( Campo.class ) ) {
                    String label = m.getName().substring( 3 );
                    campos.put( label, "");
                }

            form.setCampos(campos);
        } catch( Exception e ) {
            e.printStackTrace();
        }
    	return "./WEB-INF/Cadastrar.jsp";
    }
    

    private String chamaGetter( Object formEntidade, String nomeMetodo ) throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method m = formEntidade.getClass().getMethod( nomeMetodo );

        return m.invoke( formEntidade ).toString();
    }


	public Object preencheForm( Class<?> formClass, Map<String, String> param, Method metodo ) throws Exception {
        Object form = formClass.newInstance();
        for( Method m : formClass.getMethods() ) {
        	if(metodo.getName().equals("salvar") && m.getName().equals("setID") && (param.get("id")!=null)) {
                String nomeParam = m.getName().substring( 3 ).toLowerCase();
                String valorParam = param.get( nomeParam );
                m.invoke( form, valorParam );
        	}
            if( m.getAnnotation( Campo.class ) != null )
                if( m.getName().substring( 0, 3 ).equals( "set" ) ) {
                    String nomeParam = m.getName().substring( 3 ).toLowerCase();
                    String valorParam = param.get( nomeParam );

                    if( m.getAnnotation( Campo.class ).obrigatorio() && (valorParam == null || valorParam.trim().equals( "" )) )
                        throw new CampoNaoPreenchidoException( nomeParam );
                    else
                        m.invoke( form, valorParam );
                } else
                    throw new Exception( "O nome do método anotado por @Campo deve começar por 'set'" );
        }
        return form;
    }
}
