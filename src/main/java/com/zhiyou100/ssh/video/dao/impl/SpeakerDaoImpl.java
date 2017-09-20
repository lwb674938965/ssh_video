package com.zhiyou100.ssh.video.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.ssh.video.dao.SpeakerDao;
import com.zhiyou100.ssh.video.model.Speaker;
@SuppressWarnings("all")
public class SpeakerDaoImpl extends HibernateDaoSupport implements SpeakerDao {

	@Override
	public List<Speaker> getAllSpeaker() {
		
		return (List<Speaker>) getHibernateTemplate().find("from Speaker");
	}

	@Override
	public int findAllSpeakerCount(DetachedCriteria dc) {
		
		return getHibernateTemplate().findByCriteria(dc).size();
	}

	@Override
	public List<Speaker> findAllSpeaker(DetachedCriteria dc, Integer page) {
		return (List<Speaker>) getHibernateTemplate().findByCriteria(dc, (page-1)*5, 5);
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		speaker.setInsertTime(new Date(System.currentTimeMillis()));
		getHibernateTemplate().save(speaker);
		
	}

	@Override
	public Speaker findSpeakerById(Integer thisId) {
		
		return getHibernateTemplate().get(Speaker.class, thisId);
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		speaker.setUpdateTime(new Date(System.currentTimeMillis()));
		getHibernateTemplate().update(speaker);
		
	}

	@Override
	public void deleteSpeaker(Integer thisId) {
		Speaker speaker = getHibernateTemplate().get(Speaker.class, thisId);
		getHibernateTemplate().delete(speaker);
		
	}

}
