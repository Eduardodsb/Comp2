package sv;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CadastroAluno extends Cadastro implements Controle {
        
    @Acao( form = FormAluno.class )
    public String salvar( FormAluno form ) {
        System.out.println( "SALVOU" );
        Map<Integer, Aluno> map = new TreeMap<>();
        map = AlunoDAO.leAlunos(".//WEB-INF//alunos.txt");

        if(form.getID() != -1) {
	        for(int m : map.keySet()) {
	        	if(map.get(m).getID() == form.getID()) {
	        		(map.get(m)).setNome(form.getNome());
	        		(map.get(m)).setCelular(form.getCelular());
	        		(map.get(m)).setEmail(form.getEmail());
	        	}
	        }
	        AlunoDAO.salva(map);
        }else {
        	int aux = 0;
        	for(int m : map.keySet()) {
        		if(Integer.valueOf(map.get(m).getID()) > aux) {
        			aux = Integer.valueOf(map.get(m).getID());
        		}
        	}
        	aux++;
        	Aluno novoAluno = new Aluno();
        	novoAluno.setID(""+aux);
        	novoAluno.setNome(form.getNome());
        	novoAluno.setCelular(form.getCelular());
        	novoAluno.setEmail(form.getEmail());
        	map.put(aux, novoAluno);
        	AlunoDAO.salva(map);
        }
        return "./WEB-INF/ok.jsp";
    }
    
    @Acao( form = FormExibir.class )
    public String deletar( FormExibir form ) {
    	Map<Integer, Aluno> map = new TreeMap<>();
        map = AlunoDAO.leAlunos(".//WEB-INF//alunos.txt");
        int id = 0;
        for(int m : map.keySet()) {
        	if(map.get(m).getID() == Integer.valueOf(form.getId())) {
        		id = Integer.valueOf(form.getId());
        	}
        }
        map.remove(id);
        AlunoDAO.salva(map);
        return "./WEB-INF/ok.jsp";
    }

    @Override
    public Object preencheForm( int id ) {
        FormAluno form = new FormAluno();
        Aluno aluno = AlunoDAO.recupera( id );
        
        form.setID( "" + aluno.getID() );
        form.setCelular( aluno.getCelular() );
        form.setEmail( aluno.getEmail() );
        form.setNome( aluno.getNome() );
        
        return form;
    }
    public ArrayList<String> listar( ArrayList<String> nome) {
    	for( Aluno a : AlunoDAO.getAlunos().values() )
            nome.add( "<a href=\"SistaCad?control=sv.Cadastro&action=exibir&entidade=Aluno&ID=" + a.getID() +  "\" style=\"color:#FFFFFF\">"
                    + a.getNome() + "</a>" );
    	return nome;
    }
    
    
}
