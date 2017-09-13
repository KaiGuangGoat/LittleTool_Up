package com.littletool.dao;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class BaseDao {
	
	static interface Proxy{
		List proxy(Session session);
	}

	protected List session(Proxy proxy) {
		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();
		
		try {
			Transaction tx = session.beginTransaction();
			List result = proxy.proxy(session);
			tx.commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
}
