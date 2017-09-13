package com.littletool.dao;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.littletool.bean.DbDataBean;

public class DbDataDao extends BaseDao {

	public void save(final DbDataBean data) {
		Proxy proxy = new Proxy() {

			@Override
			public List<T> proxy(Session session) {
				session.save(data);
				return null;
			}
		};
		session(proxy);
	}

	public void save(final List<DbDataBean> dataList) {
		Proxy proxy = new Proxy() {

			@Override
			public List<T> proxy(Session session) {
				for (DbDataBean data : dataList) {
					session.save(data);
				}
				return null;
			}
		};
		session(proxy);
	}

	@SuppressWarnings("unchecked")
	public List<DbDataBean> queryAll() {
		Proxy proxy = new Proxy() {

			@Override
			public List<T> proxy(Session session) {
				Query query = session.createQuery(" from DbDataBean");
				List list = query.list();
				return list;
			}
		};
		return session(proxy);
	}

	public List<DbDataBean> queryBySourceFile(final String sourceFile) {
		Proxy proxy = new Proxy() {

			@Override
			public List<T> proxy(Session session) {
				Query query = session.createQuery(" from DbDataBean as d where d.sourceFile='"+sourceFile+"'");
				List list = query.list();
				return list;
			}
		};
		return session(proxy);
	}

}
