package com.zhiyou100.ssh.video.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.ssh.video.dao.VideoDao;
import com.zhiyou100.ssh.video.model.Page;
import com.zhiyou100.ssh.video.model.Video;
import com.zhiyou100.ssh.video.model.VideoAnalysis;
@SuppressWarnings("all")
public class VideoDaoImpl extends HibernateDaoSupport implements VideoDao {


	@Override
	public int findAllVideoConuts(DetachedCriteria dc) {
		return getHibernateTemplate().findByCriteria(dc).size();
	}

	@Override
	public List<Video> findAllVideoByConditions(DetachedCriteria dc, Integer currentPage) {
		return (List<Video>) getHibernateTemplate().findByCriteria(dc, (currentPage-1)*5, 5);
	}

	@Override
	public void addVideo(Video video) {
		video.setInsertTime(new Date(System.currentTimeMillis()));
		video.setVideoPlayTimes(0);
		getHibernateTemplate().save(video);
		
	}

	@Override
	public Video findVideoById(Integer thisId) {
		
		return getHibernateTemplate().get(Video.class, thisId);
	}

	@Override
	public void updateVideo(Video video) {
		video.setUpdateTime(new Date(System.currentTimeMillis()));
		 getHibernateTemplate().update(video);
		
	}

	@Override
	public void deleteVideo(Integer thisId) {
		Video video = getHibernateTemplate().get(Video.class, thisId);
		getHibernateTemplate().delete(video);
	}

	@Override
	public void deleteMany(Integer[] rowCheck) {
		List<Video> list = getHibernateTemplate().execute(new HibernateCallback<List<Video>>() {

			@Override
			public List<Video> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Video.class);
				List<Video> list = criteria.add(Restrictions.in("id", rowCheck)).list();
				return list;
			}
		});
		System.out.println(list);
		getHibernateTemplate().deleteAll(list);
	}

	@Override
	public void updateVideoPlayTimes(Video video) {
		getHibernateTemplate().bulkUpdate("update Video set videoPlayTimes = ? where id = ?", video.getVideoPlayTimes(),video.getId());
		
	}

	@Override
	public List<Video> findVideoByDetachedCriteria(DetachedCriteria dc) {
		
		return (List<Video>) getHibernateTemplate().findByCriteria(dc);
	}



	

}
