package sgcf.persistencia.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sgcf.persistencia.util.HibernateUtil;

public class GenericDAO <T, ID extends Serializable>{
	private Class<T> persistentClass;
	
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public GenericDAO(){
		this.persistentClass = (Class<T>)((ParameterizedType)getClass().
				getGenericSuperclass()).getActualTypeArguments()[0];
		
	}
	
	public void cadastrar(T entidade){
		
		Session sessao = HibernateUtil.abrirSessao();
		
		Transaction tx = sessao.getTransaction();
		
		try {
			tx.begin();
			sessao.save(entidade);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			sessao.close();
		}
		
	}
	
	public void alterar(T entidade){
		Session sessao = HibernateUtil.abrirSessao();
		
		Transaction tx = sessao.getTransaction();
		
		try {
			tx.begin();
			
			sessao.update(entidade);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			sessao.close();
		}
		
	}
	
	public boolean excluir(T entidade){
		Session sessao = HibernateUtil.abrirSessao();
		
		Transaction tx = sessao.getTransaction();
		
		try {
			tx.begin();
			
			sessao.delete(entidade);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
		
		return true;
	}
	
	public T getPorId(Integer id){
		Session sessao = HibernateUtil.abrirSessao();
		
		Transaction tx = sessao.getTransaction();
		
		try {
			tx.begin();
			T entidade = (T)sessao.get(getPersistentClass(), id);
			
			return entidade;
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			sessao.close();
		}
		return null;
	}
	
	public List<T> getLista(){
		List<T> lista = new ArrayList<T>();
		Session sessao = HibernateUtil.abrirSessao();
		
		Transaction tx = sessao.getTransaction();
		
		try {
			tx.begin();
			
			lista = (List<T>)sessao.createCriteria(getPersistentClass()).list();
		
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			sessao.close();
		}
		
		return lista;
	}
	
}
