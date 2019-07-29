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

public class AlunoDAO {

    static private Map<Integer, Aluno> alunos = leAlunos( ".//WEB-INF//alunos.txt" );

    public static void salva( Map<Integer, Aluno> aluno ) {
    	File arquivo = new File( ".//WEB-INF//alunos.txt" );
    	try {
			FileWriter fw = new FileWriter( arquivo );
			BufferedWriter bw = new BufferedWriter( fw );
			for(int key : aluno.keySet()) {
				bw.write( aluno.get(key).getID()+"|"+aluno.get(key).getNome()+"|"+aluno.get(key).getCelular()+"|"+aluno.get(key).getEmail());
				bw.newLine();
			}
			bw.close();
			fw.close();
			alunos = leAlunos( ".//WEB-INF//alunos.txt" );//atualizar o map alunos
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static Aluno recupera( int ID ) {
        return alunos.get( ID );
    }
    
    public static Map<Integer, Aluno> getAlunos() {
        return alunos;
    }

    static Map<Integer, Aluno> leAlunos( String arquivo ) {
        Map<Integer, Aluno> map = new TreeMap<>();
        List<String> linhas;
        try {
            linhas = Files.readAllLines( Paths.get( arquivo ), Charset.forName( "UTF-8" ) );

            for( String linha : linhas ) {
                String w[] = linha.split( "[|]" );
                Aluno aluno = new Aluno();

                aluno.setID( w[0] );
                aluno.setNome( w[1] );
                aluno.setCelular( w[2] );
                aluno.setEmail(w.length < 4 ? "" : w[3] );

                map.put( aluno.getID(), aluno );
            }
        } catch( IOException e ) {
            e.printStackTrace();
        }

        return map;
    }

}
