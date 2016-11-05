
public class Dispatcher implements Runnable {
	String [] processAttrs;
	
	public Dispatcher(String [] processAttrs) {
		this.processAttrs = processAttrs;
	}
	
	@Override
	public void run() {
		
		Processo processo = new Processo(Integer.parseInt(processAttrs[0]), Integer.parseInt(processAttrs[1]), 
				  Integer.parseInt(processAttrs[2]), Integer.parseInt(processAttrs[3]), 
				  Boolean.parseBoolean(processAttrs[4]), Boolean.parseBoolean(processAttrs[5]), 
				  Boolean.parseBoolean(processAttrs[6]), Boolean.parseBoolean(processAttrs[7]));
				  
		while(Clock.getClock() <= processo.getT_inicializa()){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Filas.enfileiraProcesso(processo);
	}

}
