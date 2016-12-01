public class Recursos {
	private static boolean scannerAlocado;
	private static boolean impressora1Alocada, impressora2Alocada;
	private static boolean modemAlocado;
	private static boolean sata1Alocada, sata2Alocada;
	
	public static synchronized void alocar(Processo p) throws SemRecursoException{
		checaRecursosAlocados(p);
		if(p.getImpressora() == 1){
			impressora1Alocada = true;
		}
		if(p.getImpressora() == 2){
			impressora2Alocada = true;
		}
		if(p.getScanner() == 1){
			scannerAlocado = true;
		}
		if(p.getModem() == 1){
			modemAlocado = true;
		}
		if(p.getDisco() == 1){
			sata1Alocada = true;
		}
		if(p.getDisco() == 2){
			sata2Alocada = true;
		}
	}
	
	private static void checaRecursosAlocados(Processo p) throws SemRecursoException{
		if(p.getImpressora() == 1){
			if(impressora1Alocada){
				throw new SemRecursoException("Printer 1");
			}
		}
		if(p.getImpressora() == 2){
			if(impressora2Alocada){
				throw new SemRecursoException("Printer 2");
			}
		}
		if(p.getScanner() == 1){
			if(scannerAlocado){
				throw new SemRecursoException("Scanner");
			}
		}
		if(p.getModem() == 1){
			if(modemAlocado){
				throw new SemRecursoException("Modem");
			}
		}
		if(p.getDisco() == 1){
			if(sata1Alocada){
				throw new SemRecursoException("Disk 1");
			}
		}
		if(p.getDisco() == 2){
			if(sata2Alocada){
				throw new SemRecursoException("Disk 2");
			}
		}
	}
	
	public static synchronized void desalocar(Processo p){
		if(p.getImpressora() == 1){
			impressora1Alocada = false;
		}
		if(p.getImpressora() == 2){
			impressora2Alocada = false;
		}
		if(p.getScanner() == 1){
			scannerAlocado = false;
		}
		if(p.getModem() == 1){
			modemAlocado = false;
		}
		if(p.getDisco() == 1){
			sata1Alocada = false;
		}
		if(p.getDisco() == 2){
			sata2Alocada = false;
		}
	}
	
	
}
