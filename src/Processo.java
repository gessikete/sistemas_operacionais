
public class Processo {

	private static int countPid = 0;
	private int pid;
	private int prioridade;
	private int qntBlocosAlocados;
	private int t_inicializa, t_processador;
	private int impressora, scanner, modem, disco;
	private int tempoExecutado;
	private int offset;

	
	public int getTempoExecutado() {
		return tempoExecutado;
	}

	public void incrTempoExecutado() {
		this.tempoExecutado++;
	}

	public Processo(int t_inicializa, int prioridade, int t_processador, int qntBlocosAlocados,
			int impressora, int scanner, int modem, int disco) {
		super();
		this.incrCountPid();
		this.pid = countPid;
		this.prioridade = prioridade;
		this.qntBlocosAlocados = qntBlocosAlocados;
		this.t_inicializa = t_inicializa;
		this.t_processador = t_processador;
		this.setImpressora(impressora);
		this.scanner = scanner;
		this.modem = modem;
		this.disco = disco;
		this.tempoExecutado = 0;
		this.offset = 0;
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
	public int getScanner() {
		return scanner;
	}

	public void setScanner(int scanner) {
		this.scanner = scanner;
	}

	public int getModem() {
		return modem;
	}

	public void setModem(int modem) {
		this.modem = modem;
	}

	public int getDisco() {
		return disco;
	}

	public void setDisco(int disco) {
		this.disco = disco;
	}

	public static void setCountPid(int countPid) {
		Processo.countPid = countPid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setTempoExecutado(int tempoExecutado) {
		this.tempoExecutado = tempoExecutado;
	}

	public int getOffset() {
		return offset;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getImpressora() {
		return impressora;
	}

	public void setImpressora(int impressora) {
		this.impressora = impressora;
	}

	
}
