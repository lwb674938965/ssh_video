package com.zhiyou100.ssh.video.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.ssh.video.dao.AdminDao;
import com.zhiyou100.ssh.video.model.Admin;
@SuppressWarnings("all")
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	@Override
	public Admin findAdminByNameAndPwd(DetachedCriteria dc) {
		List<Admin> list = (List<Admin>) getHibernateTemplate().findByCriteria(dc);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

}
