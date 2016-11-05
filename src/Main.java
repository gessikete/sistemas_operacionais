import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
    	  
    	  Dispatcher dispatcher = new Dispatcher();
    	  for(String record:records){
    		  String[] processAttrs = record.replaceAll("\\s+","").split(",");
    		  dispatcher.criaProcesso(processAttrs);
    		   //System.out.println(record);
    	  }
    }

}