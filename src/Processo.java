
public class Processo {

	private static int countPid = 0;
	private int pid;
	private int prioridade;
	private int offsetMemoria;
	private int qntBlocosAlocados;
	private int t_inicializa, t_processador;
	private boolean impressora, scanner, modem, disco;

	
	public Processo(int t_inicializa, int prioridade, int t_processador, int qntBlocosAlocados,
			boolean impressora, boolean scanner, boolean modem, boolean disco) {
		super();
		countPid++;
		this.pid = countPid;
		this.prioridade = prioridade;
		this.offsetMemoria = 0;
		this.qntBlocosAlocados = qntBlocosAlocados;
		this.t_inicializa = t_inicializa;
		this.t_processador = t_processador;
		this.impressora = impressora;
		this.scanner = scanner;
		this.modem = modem;
		this.disco = disco;
		
		System.out.println("dispatcher => ");
		System.out.println("\tPID: " + this.pid);
		System.out.println("\toffset: " + this.offsetMemoria);
		System.out.println("\tblocks: " + this.qntBlocosAlocados);
		System.out.println("\tpriority: " + this.prioridade);
		System.out.println("\ttime init: " + this.t_inicializa);
		System.out.println("\ttime: " + this.t_processador);
		System.out.println("\tprinters: " + this.impressora);
		System.out.println("\tscanners: " + this.scanner);
		System.out.println("\tmodems: " + this.modem);
		System.out.println("\tdisco: " + this.disco);
	}
	
	
	public int getT_inicializa() {
		return t_inicializa;
	}
	public void setT_inicializa(int t_inicializa) {
		this.t_inicializa = t_inicializa;
	}
	public int getT_processador() {
		return t_processador;
	}
	public void setT_processador(int t_processador) {
		this.t_processador = t_processador;
	}	
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public int getOffsetMemoria() {
		return offsetMemoria;
	}
	public void setOffsetMemoria(int offsetMemoria) {
		this.offsetMemoria = offsetMemoria;
	}
	public int getQntBlocosAlocados() {
		return qntBlocosAlocados;
	}
	public void setQntBlocosAlocados(int qntBlocosAlocados) {
		this.qntBlocosAlocados = qntBlocosAlocados;
	}
	public boolean isImpressora() {
		return impressora;
	}
	public void setImpressora(boolean impressora) {
		this.impressora = impressora;
	}
	public boolean isScanner() {
		return scanner;
	}
	public void setScanner(boolean scanner) {
		this.scanner = scanner;
	}
	public boolean isDrivers() {
		return drivers;
	}
	public void setDrivers(boolean drivers) {
		this.drivers = drivers;
	}
	
	
	
}
