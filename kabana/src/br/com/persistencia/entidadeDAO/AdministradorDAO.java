package br.com.persistencia.entidadeDAO;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import br.com.negocios.entidade.Administrador;
import br.com.persistencia.servico.HibernateGenericDAO;

public class AdministradorDAO extends HibernateGenericDAO<Administrador, Long> {
	
	public AdministradorDAO() {
		super(Administrador.class);
	}
	
	public Administrador obterAdmLoginSenha(String login, String senha){
		Criteria criteria = getSession().createCriteria(Administrador.class);
		criteria.add(Restrictions.eq("login", login)).add(Restrictions.eq("senha", senha));
		Administrador adm = unicoResultado(criteria);
		return adm;
	}
	
}
