package exceptions;

public class MemoriaInsuficienteException extends Exception{
	private int maxMem;
	
	public MemoriaInsuficienteException(int maxMem) {
		this.maxMem = maxMem;
	}
	
	public int getMaxMem(){
		return maxMem;
	}
}
