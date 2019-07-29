import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sv.Acao;
import sv.CampoNaoPreenchidoException;
import sv.Cadastro;

/**
 * Servlet implementation class SistaCad
 */
@WebServlet( "/SistaCad" )
public class SistaCad extends  HttpServlet{
    private static final long serialVersionUID = 1L;
    private Map<String,Integer> controleAcessos;
	private Properties bd;
    
	
    public void init(ServletConfig config) throws ServletException{
    	controleAcessos = new ConcurrentHashMap<String,Integer>();
    	bd = new Properties();
	   	 try {
	   		FileInputStream file = new FileInputStream(".//WEB-INF//Contas.properties");
	       	bd.load(file);
	   	 }catch(IOException e) {
	    	e.printStackTrace();
	   	 }
    }
    
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGetPost( request, response, request.getSession() );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGetPost( request, response, request.getSession() );
    }

    protected void doGetPost( HttpServletRequest request, HttpServletResponse response, HttpSession session ) throws ServletException, IOException {
        String control = request.getParameter( "control" );
        String action = request.getParameter( "action" );
        String proximaPagina;
        if(isValid(action)) {
	        try {
	        	if((session.getAttribute("usuarioLogin") == null) && ((action.toLowerCase()).compareTo("logar") != 0)) {
	        		request.getRequestDispatcher("/index.jsp").forward(request, response);
	        	}else if((session.getAttribute("usuarioLogin") == null) || ((action.toLowerCase()).compareTo("logar") == 0)){
	        		proximaPagina = verificaLogin(request,session);
	            	request.getRequestDispatcher(proximaPagina).forward(request, response);
	        	}else {
	        		 if(isValid(control)) {
	        			 proximaPagina = doAction( request, control, action );
	                 	 request.getRequestDispatcher(proximaPagina).forward(request, response);
	        		 }else if(!isValid(control)) {
	        			 proximaPagina = redireciona(action, session);
	                 	 request.getRequestDispatcher(proximaPagina).forward(request, response);
	        		 }else {
	        			 request.getRequestDispatcher("/index.jsp").forward(request, response);
	        		 }
	        	}
	        	
	        } catch( Exception e ) {
	            e.printStackTrace();
	            request.getRequestDispatcher("/index.jsp").forward(request, response);
	        }
        }else {
        	request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    private boolean isValid( String name ) {
        return name != null && !name.trim().equals( "" );
    }

    private String doAction( HttpServletRequest request, String control, String action ) throws Exception {
        Class<?> controlClass;
        try {
            controlClass = Class.forName( control );
            Map<String, String> params = filtraParams( request );

            Cadastro controlObject = (Cadastro) controlClass.newInstance();

            System.out.println( "Objeto criado: " + controlObject.getClass().getName() );

            Method metodos[] = controlClass.getDeclaredMethods();

            for( Method m : metodos )
                if( m.getName().equals( action ) )
                    if( m.isAnnotationPresent( Acao.class ) ) {
                        Class<?> formClass = m.getAnnotation( Acao.class ).form();
                        String proximaPagina = "";

                        if( formClass != Object.class ) {
                            Object form = controlObject.preencheForm( formClass, params, m );
                            proximaPagina = m.invoke( controlObject, form ).toString();
                            request.setAttribute( "form", form );
                        } else {
                            proximaPagina = m.invoke( controlObject ).toString();
                        }
                        return proximaPagina;
                    } else {
                        System.out.println( "Passou Aqui" );
                        return "./WEB-INF/AcessoNegado.jsp";
                    }

        } catch( CampoNaoPreenchidoException e ) {
            e.printStackTrace();
            request.setAttribute( "erro", e );
            return "./WEB-INF/erro.jsp";
        } catch( Exception e ) {
            e.printStackTrace();
            request.setAttribute( "erro", e );
            return "./WEB-INF/erro.jsp";
        }
        request.setAttribute( "erro",null);
        return "./WEB-INF/erro.jsp";
    }
    

    private String verificaLogin(HttpServletRequest request, HttpSession session){
        Map<String, String> parametros = filtraParams( request );
    	if(validacaoLogin(parametros)){
    		controleAcessos.remove(parametros.get("login"));
    		request.setAttribute( "nome", parametros.get("login"));//<<
    		request.setAttribute( "hora", getTime());//<<
    		session.setAttribute("usuarioLogin", parametros.get("login"));
    		return "./WEB-INF/Home.jsp";
    	}else {
    		controle(parametros.get("login"));
    		if(controleAcessos.get(parametros.get("login")) == 3) {
    			controleAcessos.remove(parametros.get("login"));
    			return "./WEB-INF/tentativasexcedida.jsp";
    		}else {
    			request.setAttribute( "msg", true);
    			request.setAttribute( "tentativaRestantes", 3-controleAcessos.get(parametros.get("login")));
    			return "/index.jsp";
    		}
    	}
    }
    
    private boolean validacaoLogin(Map<String, String> parametros) {
       return (bd.getProperty(parametros.get("login")) != null) && (bd.getProperty(parametros.get("login")).compareTo(parametros.get("senha")) == 0 ) ? true : false;

    }
    
    private void controle(String nome) {
    	if(controleAcessos.get(nome) == null) {
			controleAcessos.put(nome, 1);
		}else {
			controleAcessos.put(nome, controleAcessos.get(nome)+1);
		}
    }
    
    private Map<String, String> filtraParams( HttpServletRequest request ) {
        TreeMap<String, String> map = new TreeMap<>();

        for( String param : request.getParameterMap().keySet() )
            if( !param.equals( "control" ) && !param.equals( "action" ) )
                map.put( param.toLowerCase(), request.getParameter( param ) );

        return map;
    }
    
    private String redireciona(String action, HttpSession session){
    	if(action.compareToIgnoreCase("Home") == 0) {
    		return "./WEB-INF/Home.jsp";
    	}
    	if(action.compareToIgnoreCase("Sair") == 0) {
    		session.invalidate();
    		return "/index.jsp";
    	}
    	return "/index.jsp";
    }
    
    private String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf.format(hora);

		return dataFormatada;
	}
    

}
