
public class Processo {

	private static int countPid = 0;
	private int pid;
	private int prioridade;
	private int qntBlocosAlocados;
	private int t_inicializa, t_processador;
	private boolean impressora, scanner, modem, disco;
	private int tempoExecutado;
	private int posMemoria;

	
	public int getTempoExecutado() {
		return tempoExecutado;
	}

	public void incrTempoExecutado() {
		this.tempoExecutado++;
	}

	public Processo(int t_inicializa, int prioridade, int t_processador, int qntBlocosAlocados,
			boolean impressora, boolean scanner, boolean modem, boolean disco) {
		super();
		this.incrCountPid();
		this.pid = countPid;
		this.prioridade = prioridade;
		this.qntBlocosAlocados = qntBlocosAlocados;
		this.t_inicializa = t_inicializa;
		this.t_processador = t_processador;
		this.impressora = impressora;
		this.scanner = scanner;
		this.modem = modem;
		this.disco = disco;
		this.tempoExecutado = 0;
		this.posMemoria = 0;
	}
	
	private synchronized void incrCountPid(){
		countPid++;
	}
	
	public static int getCountPid() {
		return countPid;
	}



	public int getPid() {
		return pid;
	}



	public boolean isModem() {
		return modem;
	}



	public boolean isDisco() {
		return disco;
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
	public int getPosMemoria() {
		return posMemoria;
	}
	public void setPosMemoria(int pos_memoria) {
		this.posMemoria = pos_memoria;
	}

	
}
