package sv;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CadastroProfessor extends Cadastro implements Controle{
	@Acao( form = FormProfessor.class )
    public String salvar( FormProfessor form ) {
        System.out.println( "SALVOU" );
        Map<Integer, Professor> map = new TreeMap<>();
        map = ProfessorDAO.leProfessores(".//WEB-INF//professores.txt");

        if(form.getID() != -1) {
	        for(int m : map.keySet()) {
	        	if(map.get(m).getID() == form.getID()) {
	        		(map.get(m)).setNome(form.getNome());
	        		(map.get(m)).setCelular(form.getCelular());
	        		(map.get(m)).setEmail(form.getEmail());
	        	}
	        }
	        ProfessorDAO.salva(map);
        }else {
        	int aux = 0;
        	for(int m : map.keySet()) {
        		if(Integer.valueOf(map.get(m).getID()) > aux) {
        			aux = Integer.valueOf(map.get(m).getID());
        		}
        	}
        	aux++;
        	Professor novoProfessor = new Professor();
        	novoProfessor.setID(""+aux);
        	novoProfessor.setNome(form.getNome());
        	novoProfessor.setCelular(form.getCelular());
        	novoProfessor.setEmail(form.getEmail());
        	map.put(aux, novoProfessor);
        	ProfessorDAO.salva(map);
        }
        return "./WEB-INF/ok.jsp";
    }
    
    @Acao( form = FormExibir.class )
    public String deletar( FormExibir form ) {
    	Map<Integer, Professor> map = new TreeMap<>();
        map = ProfessorDAO.leProfessores(".//WEB-INF//professores.txt");
        int id = 0;
        for(int m : map.keySet()) {
        	if(map.get(m).getID() == Integer.valueOf(form.getId())) {
        		id = Integer.valueOf(form.getId());
        	}
        }
        map.remove(id);
        ProfessorDAO.salva(map);
        return "./WEB-INF/ok.jsp";
    }

    @Override
    public Object preencheForm( int id ) {
        FormProfessor form = new FormProfessor();
        Professor professor = ProfessorDAO.recupera( id );
        
        form.setID( "" + professor.getID() );
        form.setCelular( professor.getCelular() );
        form.setEmail( professor.getEmail() );
        form.setNome( professor.getNome() );
        
        return form;
    }
    public ArrayList<String> listar( ArrayList<String> nome) {
    	for( Professor a : ProfessorDAO.getProfessores().values() )
            nome.add( "<a href=\"SistaCad?control=sv.Cadastro&action=exibir&entidade=Professor&ID=" + a.getID() +  "\" style=\"color:#FFFFFF\">"
                    + a.getNome() + "</a>" );
    	return nome;
    }
}
