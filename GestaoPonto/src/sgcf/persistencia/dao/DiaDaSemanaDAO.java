package sgcf.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import sgcf.persistencia.entidade.DiaDaSemana;
import sgcf.persistencia.entidade.Turno;
import sgcf.persistencia.util.HibernateUtil;

public class DiaDaSemanaDAO extends GenericDAO<DiaDaSemana, Integer> {
	
	public List<DiaDaSemana> getListaPorTurno(Turno turno){
		Session sessao = HibernateUtil.abrirSessao();
		Query query = null;
		List<DiaDaSemana> dias = new ArrayList<DiaDaSemana>();
		try {
			query = sessao.createQuery("from DiaDaSemana where turno=?");
			query.setParameter(0, turno);
			dias = (List<DiaDaSemana>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sessao.close();
		}
		
		return dias;
	}
}
