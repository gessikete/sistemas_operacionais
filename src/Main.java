import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    	  ArrayList<String> records = new ArrayList<String>();
    	  try
    	  {
    	    BufferedReader reader = new BufferedReader(new FileReader("entrada.txt"));
    	    String line;
					// le todas as linhas do arquivo, sendo cada linha um processo
    	    while ((line = reader.readLine()) != null)
    	    {
    	      // adiciona as linhas a um array
						records.add(line);
    	    }
    	    reader.close();
    	  }
    	  catch (Exception e)
    	  {
    	    System.err.format("Exception occurred trying to read '%s'.", "entrada.txt");
    	    e.printStackTrace();
    	  }

				// cria os objetos dispatcher e clock 
    	  GerenciadorDeProcessos dispatcher = new GerenciadorDeProcessos();
    	  Clock clock = new Clock();

				// inicializa o dispatcher e o clock
    	  dispatcher.start();
    	  clock.start();

				// inicializa a fila de tempo real e as filas de usuario
    	  Filas.filasInit();
    	  
    	  // percorre cada um dos processos lidos do arquivo
    	  for(String record:records){
    		  String[] processAttrs = record.replaceAll("\\s+","").split(",");
					
    		  Dispatcher criador = new Dispatcher(processAttrs);
    		  Thread t = new Thread(criador);
    		  t.start();
    				  
    		   //System.out.println(record);
    	  }
    }

}