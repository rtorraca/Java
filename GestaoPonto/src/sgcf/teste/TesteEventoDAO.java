package sgcf.teste;

import java.util.List;

import sgcf.persistencia.dao.EventoDAO;
import sgcf.persistencia.entidade.Evento;

public class TesteEventoDAO {
	public static void main(String[] args) {
		Evento evento = new Evento();
		EventoDAO eventoDAO = new EventoDAO();
		
		evento.setNome("falta");
		
		//eventoDAO.cadastrar(evento);
		
		List<Evento> eventos = new EventoDAO().getLista();
		
		for (Evento evento2 : eventos) {
			System.out.println(evento2.getNome());
		}
	}
}
