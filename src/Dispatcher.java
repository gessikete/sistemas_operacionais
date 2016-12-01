import java.nio.channels.AlreadyBoundException;

import exceptions.MemoriaInsuficienteException;

public class Dispatcher implements Runnable {
	String [] processAttrs;
	
	public Dispatcher(String [] processAttrs) {
		this.processAttrs = processAttrs;
	}
	
	@Override
	public void run() {

		try {
			// Espera ate dar a hora de inicializar o processo
			while(Clock.getClock() <= Integer.parseInt(processAttrs[0])){
					Thread.sleep(300);
			}
			// Precisa criar o processo imediatamente antes de enfileirar para criar um numero de pid corretamente ordenado
			Processo processo = new Processo(Integer.parseInt(processAttrs[0]), Integer.parseInt(processAttrs[1]), 
					  Integer.parseInt(processAttrs[2]), Integer.parseInt(processAttrs[3]), 
					  Integer.parseInt(processAttrs[4]), Integer.parseInt(processAttrs[5]), 
					  Integer.parseInt(processAttrs[6]), Integer.parseInt(processAttrs[7]));
				
			boolean recursosIndisponiveis;
	
			do{
				recursosIndisponiveis = false;
				try{
					int pos_memoria = Memoria.alocar(processo);
					Recursos.alocar(processo);
					processo.setOffset(pos_memoria);
					Filas.enfileiraProcesso(processo);
				
				} catch (SemRecursoException e) {			
					System.out.println("Resource Unnavailable: " + e.getRecurso() +
							" to PID " + processo.getPid() + ", retry in 1s");
					recursosIndisponiveis = true;
					Thread.sleep(1000);
				} catch (MemoriaInsuficienteException e){
					System.out.println("Not enough memory to PID " + processo.getPid()
							+ " it requested "+ processo.getQntBlocosAlocados() 
							+ " but memory limit is " + e.getMaxMem()
							+ " aborting process");
				}
			}while(recursosIndisponiveis); // caso recursos estejam indisponíveis, tente novamente
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
