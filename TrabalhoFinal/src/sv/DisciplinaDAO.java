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

public class DisciplinaDAO {
	 static private Map<Integer, Disciplina> disciplinas = leDisciplinas( ".//WEB-INF//disciplinas.txt" );

	    public static void salva( Map<Integer, Disciplina> disciplina ) {
	    	File arquivo = new File( ".//WEB-INF//disciplinas.txt" );
	    	try {
				FileWriter fw = new FileWriter( arquivo );
				BufferedWriter bw = new BufferedWriter( fw );
				for(int key : disciplina.keySet()) {
					bw.write( disciplina.get(key).getID()+"|"+disciplina.get(key).getNome());
					bw.newLine();
				}
				bw.close();
				fw.close();
				disciplinas = leDisciplinas( ".//WEB-INF//disciplinas.txt" );//atualizar o map Disciplinas
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

	    public static Disciplina recupera( int ID ) {
	        return disciplinas.get( ID );
	    }
	    
	    public static Map<Integer, Disciplina> getDisciplinas() {
	        return disciplinas;
	    }

	    static Map<Integer, Disciplina> leDisciplinas( String arquivo ) {
	        Map<Integer, Disciplina> map = new TreeMap<>();
	        List<String> linhas;
	        try {
	            linhas = Files.readAllLines( Paths.get( arquivo ), Charset.forName( "UTF-8" ) );

	            for( String linha : linhas ) {
	                String w[] = linha.split( "[|]" );
	                Disciplina disciplina = new Disciplina();

	                disciplina.setID( w[0] );
	                disciplina.setNome( w[1] );

	                map.put( disciplina.getID(), disciplina );
	            }
	        } catch( IOException e ) {
	            e.printStackTrace();
	        }

	        return map;
	    }
}
