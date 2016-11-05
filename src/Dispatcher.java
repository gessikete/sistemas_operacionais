public class Dispatcher extends Thread{
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(300);
				if(!Filas.filaTempoReal.isEmpty()){
					this.executaTempoReal(Filas.filaTempoReal.get(0));
					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}	
	private void executaTempoReal(Processo processo) throws InterruptedException{
		System.out.println("processes " + processo.getPid() + "=>");
		System.out.println("\tP"+processo.getPid() + " STARTED");
		int i = 0;
		while(processo.getT_processador()>i){
			System.out.println("\tP" + processo.getPid() + " instruction " + (i+1));
			i++;			
			Thread.sleep(1000);			
		}
		System.out.println("\tP"+processo.getPid() + " return SIGINT");
		Filas.filaTempoReal.remove(0);
	}
}
