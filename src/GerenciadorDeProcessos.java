public class GerenciadorDeProcessos extends Thread{
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
				if(!Filas.filasProcessos.get(0).isEmpty()){
					this.executaTempoReal(Filas.filasProcessos.get(0).get(0));
					
				}else if(!Filas.filasProcessos.get(1).isEmpty()){
					this.executaUsuario(Filas.filasProcessos.get(1).get(0));
				}else if(!Filas.filasProcessos.get(2).isEmpty()){
					this.executaUsuario(Filas.filasProcessos.get(2).get(0));
				}else if(!Filas.filasProcessos.get(3).isEmpty()){
					this.executaUsuario(Filas.filasProcessos.get(3).get(0));
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}	
	
	private void executaTempoReal(Processo processo) throws InterruptedException{
		System.out.println("processes " + processo.getPid() + " =>");
		System.out.println("\tP"+processo.getPid() + " STARTED");
		int i = 0;
		while(processo.getT_processador() > i){
			System.out.println("\tP" + processo.getPid() + " instruction " + (i+1));
			i++;			
			Thread.sleep(1000);			
		}
		System.out.println("\tP"+processo.getPid() + " return SIGINT");
		Processo p = Filas.filasProcessos.get(0).remove(0);
		Memoria.desalocar(p);
	}
	
	private void executaUsuario(Processo processo) throws InterruptedException{
		System.out.println("processes " + processo.getPid() + " =>");
		System.out.println("\tP"+processo.getPid() + " STARTED");
		processo.incrTempoExecutado();
		if(processo.getTempoExecutado()<=processo.getT_processador()){
			System.out.println("\tP" + processo.getPid() + " instruction " + processo.getTempoExecutado());
			Thread.sleep(1000);
			Processo p = Filas.filasProcessos.get(processo.getPrioridade()).remove(0);
			Filas.filasProcessos.get(processo.getPrioridade()).add(p);
			System.out.println("\tP"+processo.getPid() + " READY");
			
		}else{
			System.out.println("\tP"+processo.getPid() + " return SIGINT");
			Processo p = Filas.filasProcessos.get(processo.getPrioridade()).remove(0);
			Recursos.desalocar(p);
		}
		
		
	}
}


