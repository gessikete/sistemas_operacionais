package exceptions;

public class SemRecursoException extends Exception{
	private String recurso;
	
	public SemRecursoException(String recurso){
		this.recurso = recurso;
	}
	
	public String getRecurso(){
		return recurso;
	}
}
