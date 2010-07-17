package br.com.negocios.servico;

import org.hibernate.Session;
import br.com.persistencia.util.HibernateUtil;

public class ControladorGeneric {
	
	protected Session iniciarTransacao(){
		return HibernateUtil.getInstance().createSession();
	}
	
	protected void fecharTransacao(){
		HibernateUtil.getInstance().commit();
	}
	
	protected void rollback(){
		HibernateUtil.getInstance().rollback();
	}

	protected void flush(){
		HibernateUtil.getInstance().flush();
	}
}
