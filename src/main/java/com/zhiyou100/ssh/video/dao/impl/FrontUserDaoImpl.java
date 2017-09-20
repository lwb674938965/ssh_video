package com.zhiyou100.ssh.video.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.ssh.video.dao.FrontUserDao;
import com.zhiyou100.ssh.video.model.User;
import com.zhiyou100.ssh.video.util.MD5Util;
@SuppressWarnings("all")
public class FrontUserDaoImpl extends HibernateDaoSupport implements FrontUserDao {

	@Override
	public User findUserByDetachedCriteria(DetachedCriteria dc) {
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

	@Override
	public void addUser(User user) {
		user.setPassword(MD5Util.getMD5(user.getPassword()));
		user.setInsertTime(new Date(System.currentTimeMillis()));
		getHibernateTemplate().save(user);
		
	}

	@Override
	public User updateUser(User user) {
		getHibernateTemplate().bulkUpdate("update User set nickName = ?,sex=?,birthday=?,province=?,city=?,updateTime=? where id =?", user.getNickName(),user.getSex(),user.getBirthday(),user.getProvince(),user.getCity(),new Date(System.currentTimeMillis()),user.getId());
		return getHibernateTemplate().get(User.class, user.getId());
	}

	@Override
	public User updateHeadImg(String nn, Integer thisId) {
		getHibernateTemplate().bulkUpdate("update User set headUrl=? where id =?",nn,thisId);
		return getHibernateTemplate().get(User.class,thisId);
	}

	@Override
	public User updatePassword(String newPassword, Integer thisId) {
		getHibernateTemplate().bulkUpdate("update User set password=? where id =?",MD5Util.getMD5(newPassword),thisId);
		return getHibernateTemplate().get(User.class,thisId);
	}

	@Override
	public void addCaptcha(User user, Integer code) {
		//System.out.println(code+"------"+user.getEmail());
		getHibernateTemplate().bulkUpdate("update User set captcha = ? where email = ?",""+code,user.getEmail());
	}

	@Override
	public void resetPassword(User user) {
		getHibernateTemplate().bulkUpdate("update User set password = ?,captcha = ? where email = ?",MD5Util.getMD5(user.getPassword()),null,user.getEmail());
		
	}

}
