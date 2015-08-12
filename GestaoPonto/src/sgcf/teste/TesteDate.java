package sgcf.teste;

import java.util.Date;

public class TesteDate {
	public static void main(String[] args) {
		Date dataInicio = new Date("11/02/88");
		Date dataFim = new Date("12/02/88");
		
		long diferenca = dataFim.getTime()-dataInicio.getTime();
		int tempoDia  = 1000 * 60 * 60 * 24;
		long diasDiferenca = diferenca/tempoDia;
		
		System.out.println("Diferenca:"+diasDiferenca);
	}
}
