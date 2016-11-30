
public class Dispatcher implements Runnable {
	String [] processAttrs;
	
	public Dispatcher(String [] processAttrs) {
		this.processAttrs = processAttrs;
	}
	
	@Override
	public void run() {
		// Espera ate dar a hora de inicializar o processo
		while(Clock.getClock() <= Integer.parseInt(processAttrs[0])){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Precisa criar o processo imediatamente antes de enfileirar para criar um numero de pid corretamente ordenado
		Processo processo = new Processo(Integer.parseInt(processAttrs[0]), Integer.parseInt(processAttrs[1]), 
				  Integer.parseInt(processAttrs[2]), Integer.parseInt(processAttrs[3]), 
				  Boolean.parseBoolean(processAttrs[4]), Boolean.parseBoolean(processAttrs[5]), 
				  Boolean.parseBoolean(processAttrs[6]), Boolean.parseBoolean(processAttrs[7]));
		
		// So Aloca se tiver memoria, caso controrio falhe sileciosamente
		int pos_memoria = Memoria.alocar(processo);
				
		if(pos_memoria != -1){
			processo.setPosMemoria(pos_memoria);
			Filas.enfileiraProcesso(processo);
		}
		
	}

}
