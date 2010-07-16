package teste;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.negocios.entidade.Administrador;
import br.com.persistencia.entidadeDAO.AdministradorDAO;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		AdministradorDAO administradorDAO = new AdministradorDAO();
		
		session = factory.openSession();
		administradorDAO.setSession(session);
		session.beginTransaction();
		List<Administrador> lista = administradorDAO.listar();
		for (Administrador administrador : lista) {
			System.out.println(administrador.getNome());
		}
		session.getTransaction().commit();
		session.close();
		
		
	}

}
