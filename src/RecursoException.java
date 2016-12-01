
public class RecursoException extends Exception{
	private String recurso;
	
	public RecursoException(String recurso){
		this.recurso = recurso;
	}
	
	public String getRecurso(){
		return recurso;
	}
}
