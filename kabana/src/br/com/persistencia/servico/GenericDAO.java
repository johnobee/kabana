package br.com.persistencia.servico;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

public interface GenericDAO<T, ID extends Serializable> {
	
	public Integer inserir(T object);
	public void delete(T object);
	public void update(T object);
	public T obter(ID id);
	public List<T> listar();
	public List<T> pesquisar(Criteria criteria);
	public void merger(T object);
	public T load(ID id);


}
