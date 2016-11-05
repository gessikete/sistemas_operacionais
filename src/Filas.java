import java.util.ArrayList;

public class Filas {
	static ArrayList<Processo> filaTempoReal = new ArrayList<>();
	static ArrayList<Processo> filaUsuario1 = new ArrayList<>();
	static ArrayList<Processo> filaUsuario2 = new ArrayList<>();
	static ArrayList<Processo> filaUsuario3 = new ArrayList<>();
	
	public static boolean enfileiraProcesso(Processo processo){
		System.out.println("dispatcher => ");
		System.out.println("\tPID: " + processo.getPid());
		System.out.println("\toffset: " + processo.getOffsetMemoria());
		System.out.println("\tblocks: " + processo.getQntBlocosAlocados());
		System.out.println("\tpriority: " + processo.getPrioridade());
		System.out.println("\ttime init: " + processo.getT_inicializa());
		System.out.println("\ttime: " + processo.getT_processador());
		System.out.println("\tprinters: " + processo.isImpressora());
		System.out.println("\tscanners: " + processo.isScanner());
		System.out.println("\tmodems: " + processo.isModem());
		System.out.println("\tdisco: " + processo.isDisco());
		if(processo.getPrioridade() == 0){
			return filaTempoReal.add(processo);
		}else if(processo.getPrioridade()==1){
			return filaUsuario1.add(processo);
		}else if(processo.getPrioridade()==2){
			return filaUsuario2.add(processo);
		}else{
			return filaUsuario3.add(processo);
		}
				
	}
}
