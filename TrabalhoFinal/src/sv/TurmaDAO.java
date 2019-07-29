package sv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TurmaDAO {
	static private Map<Integer, Turma> turmas = leTurmas( ".//WEB-INF//turmas.txt" );

    public static void salva( Map<Integer, Turma> aluno ) {
    	File arquivo = new File( ".//WEB-INF//turmas.txt" );
    	try {
			FileWriter fw = new FileWriter( arquivo );
			BufferedWriter bw = new BufferedWriter( fw );
			for(int key : aluno.keySet()) {
				bw.write( aluno.get(key).getID()+"|"+aluno.get(key).getNome()+"|"+aluno.get(key).getProfessor()+"|"+aluno.get(key).getDisciplina());
				bw.newLine();
			}
			bw.close();
			fw.close();
			turmas = leTurmas( ".//WEB-INF//turmas.txt" );//atualizar o map turmas.
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static Turma recupera( int ID ) {
        return turmas.get( ID );
    }
    
    public static Map<Integer, Turma> getTurmas() {
        return turmas;
    }

    static Map<Integer, Turma> leTurmas( String arquivo ) {
        Map<Integer, Turma> map = new TreeMap<>();
        List<String> linhas;
        try {
            linhas = Files.readAllLines( Paths.get( arquivo ), Charset.forName( "UTF-8" ) );

            for( String linha : linhas ) {
                String w[] = linha.split( "[|]" );
                Turma turma = new Turma();

                turma.setID( w[0] );
                turma.setNome( w[1] );
                turma.setProfessor( w[2] );
                turma.setDisciplina(w.length < 4 ? "" : w[3] );

                map.put( turma.getID(), turma );
            }
        } catch( IOException e ) {
            e.printStackTrace();
        }

        return map;
    }
}
