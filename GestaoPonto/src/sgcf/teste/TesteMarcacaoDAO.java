package sgcf.teste;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import sgcf.persistencia.dao.DiaDaSemanaDAO;
import sgcf.persistencia.dao.MarcacaoDAO;
import sgcf.persistencia.dao.TipoDiaDAO;
import sgcf.persistencia.dao.TurnoDAO;
import sgcf.persistencia.entidade.DiaDaSemana;
import sgcf.persistencia.entidade.Marcacao;
import sgcf.persistencia.entidade.TipoDia;
import sgcf.persistencia.entidade.Turno;

public class TesteMarcacaoDAO {
	public static void main(String[] args) {
		MarcacaoDAO marcacaoDAO = new MarcacaoDAO();
		Marcacao marcacao = new Marcacao();
		Calendar c = Calendar.getInstance();
		c.set(2011, 1, 1, 17, 45);
		Date d = new Date();
		d.setTime(c.getTimeInMillis());
		marcacao.setDia(new DiaDaSemanaDAO().getPorId(5));
		marcacao.setNome("S2");
		marcacao.setTipomarcacao('s');
		marcacao.setHorario(d);
				
		List<Marcacao> lista = marcacaoDAO.getLista();
		
		Marcacao entrada = null;
		for (Marcacao marcacao2 : lista) {
			if( marcacao2.getTipomarcacao() == 'e' && marcacao2.getSaida() == null )
				entrada = marcacao2;
		}
		
	
		
		if(entrada != null ){
			if( marcacao.getTipomarcacao() == 'e'){
				System.out.println("Existe entrada sem saída");
			}else{
				
				Calendar c1 = Calendar.getInstance();
				Calendar c2 = Calendar.getInstance();
				Double total = 0.0;
				Double diferenca = 0.0;
				Double horasini = 0.0;
				Double horasfim = 0.0;
				for (Marcacao marcacao1 : lista) {
					if(marcacao1.getSaida() != null){
						c1.setTime(marcacao1.getHorario());
						c2.setTime(marcacao1.getSaida().getHorario());
						horasini = (double) (c1.get(Calendar.HOUR_OF_DAY) + ((double)c1.get(Calendar.MINUTE)/60));
						horasfim = (double) (c2.get(Calendar.HOUR_OF_DAY) + ((double)c2.get(Calendar.MINUTE)/60));
	
						diferenca = horasfim - horasini;
						total += diferenca;
					}
				}
				c1.setTime(entrada.getHorario());
				c2.setTime(marcacao.getHorario());
				horasini = (double) (c1.get(Calendar.HOUR_OF_DAY) + ((double)c1.get(Calendar.MINUTE)/60));
				horasfim = (double) (c2.get(Calendar.HOUR_OF_DAY) + ((double)c2.get(Calendar.MINUTE)/60));
				diferenca = horasfim - horasini;
				if(diferenca < 0){
					System.out.println("A saída deve ser maior que a entrada!");
				}else{
					total += diferenca;
					System.out.println("Total: "+ total);
					if(total > entrada.getDia().getJornada()){
						System.out.println("Ultrapassou o limite da jornada do dia");
					}else{
						marcacaoDAO.cadastrar(marcacao);
						entrada.setSaida(marcacao);
						marcacaoDAO.alterar(entrada);
					}
				}
			}
		}else{
			if( marcacao.getTipomarcacao() == 'e'){
				marcacaoDAO.cadastrar(marcacao);
			}else{
				System.out.println("Não existe entrada para essa saída");
			}
		}
		
		
		
		
		
	
		
		
		
	}
}
