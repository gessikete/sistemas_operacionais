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
    	    while ((line = reader.readLine()) != null)
    	    {
    	      records.add(line);
    	    }
    	    reader.close();
    	  }
    	  catch (Exception e)
    	  {
    	    System.err.format("Exception occurred trying to read '%s'.", "entrada.txt");
    	    e.printStackTrace();
    	  }

    	  GerenciadorDeProcessos dispatcher = new GerenciadorDeProcessos();
    	  Clock clock = new Clock();
    	  dispatcher.start();
    	  clock.start();
    	  Filas.filasInit();
    	  
    	  
    	  for(String record:records){
    		  String[] processAttrs = record.replaceAll("\\s+","").split(",");
    		  Dispatcher criador = new Dispatcher(processAttrs);
    		  Thread t = new Thread(criador);
    		  t.start();
    	  }
    }

}