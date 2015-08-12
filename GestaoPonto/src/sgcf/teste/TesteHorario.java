package sgcf.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import sgcf.persistencia.dao.DiaDaSemanaDAO;
import sgcf.persistencia.dao.MarcacaoDAO;
import sgcf.persistencia.entidade.DiaDaSemana;
import sgcf.persistencia.entidade.Marcacao;

public class TesteHorario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DiaDaSemana dia = new DiaDaSemanaDAO().getPorId(1);
		List<Marcacao> marcacoes = new MarcacaoDAO().getListaPorDiaDaSemana(dia);
		
		Calendar c = Calendar.getInstance();
		
		
		for (Marcacao marcacao : marcacoes) {
			Date d = marcacao.getHorario();
			c.setTime(d);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			System.out.println(sdf.format(d));
			System.out.println("Horas: "+c.get(Calendar.HOUR_OF_DAY));
			System.out.println("Minutos: "+c.get(Calendar.MINUTE));
		}

	}

}
