package com.littletool.dao;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;
import org.hibernate.classic.Session;

import com.littletool.bean.DbDataBean;
import com.littletool.bean.RsiAllBean;
import com.littletool.dao.BaseDao.Proxy;

public class RsiAllDao extends BaseDao{
	public void save(final RsiAllBean data) {
		Proxy proxy = new Proxy() {

			@Override
			public List<T> proxy(Session session) {
				session.save(data);
				return null;
			}
		};
		session(proxy);
	}
	
	public void save(final List<RsiAllBean> dataList) {
		Proxy proxy = new Proxy() {

			@Override
			public List<T> proxy(Session session) {
				for (RsiAllBean data : dataList) {
					session.save(data);
				}
				return null;
			}
		};
		session(proxy);
	}
}
