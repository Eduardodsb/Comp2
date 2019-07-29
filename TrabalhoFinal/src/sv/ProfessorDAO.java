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

public class ProfessorDAO {
	static private Map<Integer, Professor> professores = leProfessores( ".//WEB-INF//professores.txt" );

    public static void salva( Map<Integer, Professor> professor ) {
    	File arquivo = new File( ".//WEB-INF//professores.txt" );
    	try {
			FileWriter fw = new FileWriter( arquivo );
			BufferedWriter bw = new BufferedWriter( fw );
			for(int key : professor.keySet()) {
				bw.write( professor.get(key).getID()+"|"+professor.get(key).getNome()+"|"+professor.get(key).getCelular()+"|"+professor.get(key).getEmail());
				bw.newLine();
			}
			bw.close();
			fw.close();
			professores = leProfessores( ".//WEB-INF//professores.txt" );//atualizar o map professor
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static Professor recupera( int ID ) {
        return professores.get( ID );
    }
    
    public static Map<Integer, Professor> getProfessores() {
        return professores;
    }

    static Map<Integer, Professor> leProfessores( String arquivo ) {
        Map<Integer, Professor> map = new TreeMap<>();
        List<String> linhas;
        try {
            linhas = Files.readAllLines( Paths.get( arquivo ), Charset.forName( "UTF-8" ) );

            for( String linha : linhas ) {
                String w[] = linha.split( "[|]" );
                Professor professor = new Professor();

                professor.setID( w[0] );
                professor.setNome( w[1] );
                professor.setCelular( w[2] );
                professor.setEmail(w.length < 4 ? "" : w[3] );

                map.put( professor.getID(), professor );
            }
        } catch( IOException e ) {
            e.printStackTrace();
        }

        return map;
    }
}
