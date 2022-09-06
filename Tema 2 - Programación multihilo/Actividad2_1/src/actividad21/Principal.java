package actividad21;

public class Principal {

	public static void main(String[] args) {
		
		HiloTic tic = new HiloTic("TIC");
		HiloTac tac = new HiloTac("TAC");
		
	
		tic.start();
		tac.start();

	}

}
