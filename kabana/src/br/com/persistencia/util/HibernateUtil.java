package br.com.persistencia.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private ThreadLocal<Session> session;
	
	private static HibernateUtil hibernateUtil;
	private SessionFactory sessionFactory;
	
	private HibernateUtil() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = new ThreadLocal<Session>();
	}
	
	public synchronized static HibernateUtil getInstance(){	
		if(hibernateUtil == null){
			hibernateUtil = new HibernateUtil();
		}	
		return hibernateUtil;
	}
	
	public Session createSession(){
		Session session = sessionFactory.openSession();
		this.session.set(session);
		session.beginTransaction();
		return session;
	}
	
	public void commit(){
		Session session = this.session.get();
		session.getTransaction().commit();
		session.close();
		this.session.set(null);
	}
	
	public void flush(){
		Session session = this.session.get();
		session.flush();
	}
	
	public void rollback(){
		Session session = this.session.get();
		session.getTransaction().rollback();
		session.close();
		this.session.set(null);
	}

}
