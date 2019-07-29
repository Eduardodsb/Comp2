package sv;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CadastroDisciplina extends Cadastro implements Controle {
    @Acao( form = FormDisciplina.class )
    public String salvar( FormDisciplina form ) {
        System.out.println( "SALVOU" );
        Map<Integer, Disciplina> map = new TreeMap<>();
        map = DisciplinaDAO.leDisciplinas(".//WEB-INF//disciplinas.txt");

        if(form.getID() != -1) {
	        for(int m : map.keySet()) {
	        	if(map.get(m).getID() == form.getID()) {
	        		(map.get(m)).setNome(form.getNome());
	        	}
	        }
	       DisciplinaDAO.salva(map);
        }else {
        	int aux = 0;
        	for(int m : map.keySet()) {
        		if(Integer.valueOf(map.get(m).getID()) > aux) {
        			aux = Integer.valueOf(map.get(m).getID());
        		}
        	}
        	aux++;
        	Disciplina novaDisciplina = new Disciplina();
        	novaDisciplina.setID(""+aux);
        	novaDisciplina.setNome(form.getNome());
        	map.put(aux, novaDisciplina);
        	DisciplinaDAO.salva(map);
        }
        return "./WEB-INF/ok.jsp";
    }
    
    @Acao( form = FormExibir.class )
    public String deletar( FormExibir form ) {
    	Map<Integer, Disciplina> map = new TreeMap<>();
        map = DisciplinaDAO.leDisciplinas(".//WEB-INF//disciplinas.txt");
        int id = 0;
        for(int m : map.keySet()) {
        	if(map.get(m).getID() == Integer.valueOf(form.getId())) {
        		id = Integer.valueOf(form.getId());
        	}
        }
        map.remove(id);
        DisciplinaDAO.salva(map);
        return "./WEB-INF/ok.jsp";
    }

    @Override
    public Object preencheForm( int id ) {
        FormDisciplina form = new FormDisciplina();
        Disciplina aluno = DisciplinaDAO.recupera( id );
        
        form.setID( "" + aluno.getID() );
        form.setNome( aluno.getNome() );
        
        return form;
    }
    public ArrayList<String> listar( ArrayList<String> nome) {
    	for( Disciplina a : DisciplinaDAO.getDisciplinas().values() )
            nome.add( "<a href=\"SistaCad?control=sv.Cadastro&action=exibir&entidade=Disciplina&ID=" + a.getID() +  "\" style=\"color:#FFFFFF\">"
                    + a.getNome() + "</a>" );
    	return nome;
    }
}
