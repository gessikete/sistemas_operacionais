
public class Recursos {
	private static boolean scannerAlocado;
	private static boolean impressora1Alocada, impressora2Alocada;
	private static boolean modemAlocado;
	private static boolean sata1Alocada, sata2Alocada;
	
	public static synchronized boolean alocar(Processo p){
		if(p.getImpressora() == 1){
			if(impressora1Alocada){
				return false;
			}
			impressora1Alocada = true;
		}
		if(p.getImpressora() == 2){
			if(impressora2Alocada){
				return false;
			}
			impressora2Alocada = true;
		}
		if(p.getScanner() == 1){
			if(scannerAlocado){
				return false;
			}
			scannerAlocado = true;
		}
		if(p.getModem() == 1){
			if(modemAlocado){
				return false;
			}
			modemAlocado = true;
		}
		if(p.getDisco() == 1){
			if(sata1Alocada){
				return false;
			}
			sata1Alocada = true;
		}
		if(p.getDisco() == 2){
			if(sata2Alocada){
				return false;
			}
			sata2Alocada = true;
		}
		return true;
		
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
