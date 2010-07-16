package br.com.persistencia.entidadeDAO;

import br.com.negocios.entidade.Administrador;
import br.com.persistencia.servico.HibernateGenericDAO;

public class AdministradorDAO extends HibernateGenericDAO<Administrador, Long> {
	
	public AdministradorDAO() {
		super(Administrador.class);
	}
	
}
