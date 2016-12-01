import java.util.ArrayList;
import java.util.List;
import exceptions.*;

public class Filas {
    private static List<Processo> filaTempoReal = new ArrayList<Processo>();
    private static List<Processo> filaUsuario1 = new ArrayList<Processo>();
    private static List<Processo> filaUsuario2 = new ArrayList<Processo>();
    private static List<Processo> filaUsuario3 = new ArrayList<Processo>();
    public static List<List<Processo>> filasProcessos = new ArrayList<List<Processo>>();

    public static void filasInit() {
        filasProcessos.add(filaTempoReal);
        filasProcessos.add(filaUsuario1);
        filasProcessos.add(filaUsuario2);
        filasProcessos.add(filaUsuario3);
    }

    public static synchronized boolean enfileiraProcesso(Processo processo) throws SemRecursoException{
    	if(getTotalProcessos() > 1000)
    		throw new SemRecursoException("Process Queue");
        System.out.println("dispatcher => ");
        System.out.println("\tPID: " + processo.getPid());
        System.out.println("\toffset: " + processo.getOffset());
        System.out.println("\tblocks: " + processo.getQntBlocosAlocados());
        System.out.println("\tpriority: " + processo.getPrioridade());
        System.out.println("\ttime init: " + processo.getT_inicializa());
        System.out.println("\ttime: " + processo.getT_processador());
        System.out.println("\tprinters: " + processo.getImpressora());
        System.out.println("\tscanners: " + processo.getScanner());
        System.out.println("\tmodems: " + processo.getModem());
        System.out.println("\tdisco: " + processo.getDisco());

        return filasProcessos.get(processo.getPrioridade()).add(processo);

    }
    
    private static int getTotalProcessos(){
    	return filaTempoReal.size() + filaUsuario1.size() + filaUsuario2.size() + filaUsuario2.size();
    }
}
