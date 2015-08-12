package sgcf.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import sgcf.persistencia.entidade.Ferias;
import sgcf.persistencia.entidade.Parcela;
import sgcf.persistencia.util.HibernateUtil;

public class ParcelaDAO extends GenericDAO<Parcela, Integer>{
	public List<Parcela> getListaPorFerias(Ferias ferias){
		Session sessao = HibernateUtil.abrirSessao();
		Query query = null;
		List<Parcela> parcelas = new ArrayList<Parcela>();
		try {
			query = sessao.createQuery("from Parcela where ferias=?");
			query.setParameter(0, ferias);
			parcelas = (List<Parcela>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sessao.close();
		}
		
		return parcelas;
	}
}
