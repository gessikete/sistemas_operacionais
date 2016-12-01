import exceptions.*;

public class Memoria {
	private static final int TAM_REAL = 64;
	private static final int TAM_USUARIO = 960;
	private static boolean[] tempoReal = new boolean[TAM_REAL];
	private static boolean[] usuario = new boolean[TAM_USUARIO];


	/**
	 * @param qnt_alocar
	 * @return posicao do vetor caso aloque, -1 caso contrario
	 */
	public static synchronized int alocar(Processo p) throws SemRecursoException, MemoriaInsuficienteException{
		if(p.getPrioridade() == 0){
			if(p.getQntBlocosAlocados() > TAM_REAL)
				throw new MemoriaInsuficienteException(TAM_REAL);
			return aloca(p.getQntBlocosAlocados(), tempoReal, TAM_REAL);
		}
		else{
			if(p.getQntBlocosAlocados() > TAM_USUARIO)
				throw new MemoriaInsuficienteException(TAM_USUARIO);
			return aloca(p.getQntBlocosAlocados(), usuario, TAM_USUARIO);
		}
	}
	
	public static void desalocar(Processo p){
		if(p.getPrioridade() == 0)
			desaloca(p.getOffset(), p.getQntBlocosAlocados(), tempoReal);
		else
			desaloca(p.getOffset(), p.getQntBlocosAlocados(), usuario);
	}
	
	public static void desalocaTempoReal(int pos_desaloca, int qnt_desaloca){
		desaloca(pos_desaloca, qnt_desaloca, tempoReal);
	}

	public static void desalocaUsuario(int pos_desaloca, int qnt_desaloca){
		desaloca(pos_desaloca, qnt_desaloca, usuario);
	}
	

	private static void desaloca(int pos_desaloca, int qnt_desaloca, boolean[] fila){
		for(int i = pos_desaloca; i < pos_desaloca + qnt_desaloca; i++){
			fila[i] = false;
		}
	}
	
	// podemos fazer quebrar com excessao ao inves de retornar bool
	private static int aloca(int qnt_alocar, boolean[] fila, int max_fila) throws SemRecursoException, MemoriaInsuficienteException{
		int qnt_livre = 0;
		int k = 0, pos_free = -1;
		
		// checa a quantidade de espacos livres na fila informada ate encontrar
		// a quantidade a alocar ou alcancar o tamanho maximo da fila
		while(pos_free == -1 && k < max_fila){
			int i = 0;
			for(i = k; qnt_livre < qnt_alocar && i < max_fila; i++){
				if(fila[i]){
					break;
				}
				qnt_livre++;
			}
			if(qnt_livre == qnt_alocar){
				pos_free = k;
			}
			k = i + 1;
			qnt_livre = 0;
		}
		// se a quantidade de espacos livres for maior a quantidade que se quer alocar
		if(pos_free != -1){
			for(int i = pos_free; i < pos_free + qnt_alocar; i++){
				fila[i] = true;
			}
		}
		else{
			throw new SemRecursoException("Memory");
		}
		return pos_free;
	}
	
		
	public static void showMemory(){
		System.out.println("Tempo Real");
		for(int i = 0; i < TAM_REAL; i++)
			System.out.print(i + "\t| ");
		System.out.println();
		for(int i = 0; i < TAM_REAL; i++){
			if(tempoReal[i])
				System.out.print("*");
			else
				System.out.print(" ");
			System.out.print("\t| ");
		}

		System.out.println("\nUsuario");
		for(int i = TAM_REAL; i < TAM_USUARIO+TAM_REAL; i++)
			System.out.print(i + "\t| ");
		System.out.println();
		for(int i = 0; i < TAM_USUARIO; i++){
			if(usuario[i])
				System.out.print("*");
			else
				System.out.print(" ");
			System.out.print("\t| ");
		}
		System.out.println();

	}
}
