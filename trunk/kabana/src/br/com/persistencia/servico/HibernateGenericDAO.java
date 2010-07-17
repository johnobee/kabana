package br.com.persistencia.servico;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class HibernateGenericDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {
	
	private Session session;
	private Class<T> classe;
	public HibernateGenericDAO(Class<T> classe) {
		this.classe = classe;
	}
	
	public Integer inserir(Object object) {
		return (Integer) session.save(object);
	}
		
	@SuppressWarnings("unchecked")
	public List<T> listar() {
		return session.createCriteria(classe).list();
	}
	
	@SuppressWarnings("unchecked")
	public T obter(ID id) {
		T object = (T) session.get(classe, id);
		return object;
	}
		
	public void update(Object object) {
		session.update(object);
	}
	
	@SuppressWarnings("unchecked")
	public T load(ID id) {
		T object = (T) session.load(classe, id);
		return object;
	}
	
	public void merger(Object object) {
		session.update(object);
	}
	
	public void delete(Object object) {
		session.delete(object);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> pesquisar(Criteria criteria) {
		List<T> listObject = criteria.list();
		return listObject;
	}
	
	@SuppressWarnings("unchecked")
	public T unicoResultado(Criteria criteria){
		return (T) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> paginador(Criteria criteria, Integer inicio, Integer fim){
		criteria.setFirstResult(inicio);
		criteria.setMaxResults(fim);
		List<T> objects = criteria.list();
		return objects;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}


}
