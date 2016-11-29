
public class Memoria {
	private static final int TAM_REAL = 64;
	private static final int TAM_USUARIO = 960;
	private static boolean[] tempoReal = new boolean[TAM_REAL];
	private static boolean[] usuario = new boolean[TAM_USUARIO];


	/**
	 * @param qnt_alocar
	 * @return posição do vetor caso aloque, -1 caso contrário
	 */
	public static int alocar(Processo p){
		if(p.getPrioridade() == 0)
			return aloca(p.getQntBlocosAlocados(), tempoReal, TAM_REAL);
		else
			return aloca(p.getQntBlocosAlocados(), usuario, TAM_USUARIO);
	}
	
	public static void desalocar(Processo p){
		if(p.getPrioridade() == 0)
			desaloca(p.getPosMemoria(), p.getQntBlocosAlocados(), tempoReal);
		else
			desaloca(p.getPosMemoria(), p.getQntBlocosAlocados(), usuario);
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
	
	// podemos fazer quebrar com excessão ao invés de retornar bool
	private static int aloca(int qnt_alocar, boolean[] fila, int max_fila){
		int qnt_livre = 0;
		int k = 0, pos_free = -1;
		
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
		if(pos_free != -1){
			for(int i = pos_free; i < pos_free + qnt_alocar; i++){
				fila[i] = true;
			}
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

		System.out.println("\nUsuário");
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
