package sv;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CadastroTurma extends Cadastro implements Controle {
	   
    @Acao( form = FormTurma.class )
    public String salvar( FormTurma form ) {
        Map<Integer, Turma> map = new TreeMap<>();
        map = TurmaDAO.leTurmas(".//WEB-INF//turmas.txt");

        if(form.getID() != -1) {
        	if(verificaCampos(form)) {
                System.out.println( "SALVOU" );
		        for(int m : map.keySet()) {
		        	if(map.get(m).getID() == form.getID()) {
		        		(map.get(m)).setNome(form.getNome());
		        		(map.get(m)).setProfessor(form.getProfessor());
		        		(map.get(m)).setDisciplina(form.getDisciplina());
		        	}
		        }
		        TurmaDAO.salva(map);
        	}else {
        		return "./WEB-INF/Erroturma.jsp";
        	}
        }else {
        	int aux = 0;
        	for(int m : map.keySet()) {
        		if(Integer.valueOf(map.get(m).getID()) > aux) {
        			aux = Integer.valueOf(map.get(m).getID());
        		}
        	}
        	if(verificaCampos(form)) {
                System.out.println( "SALVOU" );
	        	aux++;
	        	Turma novoAluno = new Turma();
	        	novoAluno.setID(""+aux);
	        	novoAluno.setNome(form.getNome());
	        	novoAluno.setProfessor(form.getProfessor());
	        	novoAluno.setDisciplina(form.getDisciplina());
	        	map.put(aux, novoAluno);
	        	TurmaDAO.salva(map);
        	}else {
        		return "./WEB-INF/Erroturma.jsp";
        	}
        }
        return "./WEB-INF/ok.jsp";
    }
    
    
    private boolean verificaCampos( FormTurma form ) {
    	Map<Integer, Professor> mapProfessores = new TreeMap<>();
        mapProfessores = ProfessorDAO.leProfessores(".//WEB-INF//professores.txt");
        int auxProf = 0;
        Map<Integer, Disciplina> mapDisciplinas = new TreeMap<>();
        mapDisciplinas = DisciplinaDAO.leDisciplinas(".//WEB-INF//disciplinas.txt");
        int auxDisc = 0;
        for(Integer m : mapProfessores.keySet()) {
        	if(((mapProfessores.get(m)).getNome()).compareToIgnoreCase(form.getProfessor()) == 0) {
        		auxProf++;
        	}
        }
        for(Integer m : mapDisciplinas.keySet()) {
        	if(((mapDisciplinas.get(m)).getNome()).compareToIgnoreCase(form.getDisciplina()) == 0) {
        		auxDisc++;
        	}
        }
        if(auxProf > 0 && auxDisc > 0) {
        	return true;
        }
        return false;
    }
    
    @Acao( form = FormExibir.class )
    public String deletar( FormExibir form ) {
    	Map<Integer, Turma> map = new TreeMap<>();
        map = TurmaDAO.leTurmas(".//WEB-INF//turmas.txt");
        int id = 0;
        for(int m : map.keySet()) {
        	if(map.get(m).getID() == Integer.valueOf(form.getId())) {
        		id = Integer.valueOf(form.getId());
        	}
        }
        map.remove(id);
        TurmaDAO.salva(map);
        return "./WEB-INF/ok.jsp";
    }

    @Override
    public Object preencheForm( int id ) {
        FormTurma form = new FormTurma();
        Turma turma = TurmaDAO.recupera( id );
        
        form.setID( "" + turma.getID() );
        form.setProfessor( turma.getProfessor() );
        form.setDisciplina( turma.getDisciplina() );
        form.setNome( turma.getNome() );
        
        return form;
    }
    public ArrayList<String> listar( ArrayList<String> nome) {
    	for( Turma a : TurmaDAO.getTurmas().values() )
            nome.add( "<a href=\"SistaCad?control=sv.Cadastro&action=exibir&entidade=Turma&ID=" + a.getID() +  "\" style=\"color:#FFFFFF\">"
                    + a.getNome() + "</a>" );
    	return nome;
    }
}
