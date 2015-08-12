package sgcf.teste;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class TesteTurnoDAO {
	public static void main(String[] args) {
		TurnoDAO turnodao = new TurnoDAO();
		
		Turno turno = new Turno();
		
		turno = turnodao.getPorId(2);
		
		TipoDia tipodia = new TipoDia();
		
		tipodia.setNome("trabalhado");
		
		//new TipoDiaDAO().cadastrar(tipodia);
		
		DiaDaSemana dia = new DiaDaSemana();
		
		dia.setNome("Segunda-feira");
		dia.setTurno(turno);
		dia.setJornada(40.0);
		dia.setTipodia(tipodia);
		
		//new DiaDaSemanaDAO().cadastrar(dia);
		
		
		DiaDaSemanaDAO diadasemanadao = new DiaDaSemanaDAO();
		
		List<DiaDaSemana> dias = new ArrayList<DiaDaSemana>();
		
		dias = diadasemanadao.getLista();
		/*
		for (DiaDaSemana diaDaSemana : dias) {
			System.out.println(diaDaSemana.getNome());
			System.out.println(diaDaSemana.getTipodia().getNome());
			System.out.println(diaDaSemana.getJornada().toString());
		}
		*/
		
		Marcacao marcacao = new Marcacao();
		
		MarcacaoDAO marcacaodao= new MarcacaoDAO();
		
		dia = diadasemanadao.getPorId(1);
		
		Date d = new Date();
		
		Calendar c = Calendar.getInstance();
		
		c.set(2011, 1, 1, 7, 30);
		
		d.setTime(c.getTimeInMillis());
		
		marcacao.setDia(dia);
		marcacao.setNome("E1");
		marcacao.setTipomarcacao('e');
		marcacao.setHorario(d);
		
		marcacaodao.cadastrar(marcacao);
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		List<Marcacao> marcacoes = new ArrayList<Marcacao>();
		
		marcacoes = marcacaodao.getLista();
		
		for (Marcacao marcacao2 : marcacoes) {
			System.out.println("Dia: "+marcacao2.getDia().getNome());
			System.out.println("Nome: "+marcacao2.getNome());
			System.out.println("Tipo: "+marcacao2.getTipomarcacao());
			System.out.println("Horario: "+ sdf.format(d));
		}
	}
}

