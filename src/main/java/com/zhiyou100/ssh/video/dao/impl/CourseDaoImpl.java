package com.zhiyou100.ssh.video.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.ssh.video.dao.CourseDao;
import com.zhiyou100.ssh.video.model.Course;
@SuppressWarnings("all")
public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {

	@Override
	public List<Course> getAllCourse() {
	
		return (List<Course>) getHibernateTemplate().find("from Course");
	}

	@Override
	public int findAllCourseCount(DetachedCriteria dc) {
		
		return getHibernateTemplate().findByCriteria(dc).size();
	}

	@Override
	public List<Course> findAllCourse(DetachedCriteria dc, Integer page) {
		return (List<Course>) getHibernateTemplate().findByCriteria(dc, (page-1)*5, 5);
	}

	@Override
	public void addCourse(Course course) {
		course.setInsertTime(new Date(System.currentTimeMillis()));
		getHibernateTemplate().save(course);
		
	}

	@Override
	public Course findCourseById(Integer thisId) {
		
		return getHibernateTemplate().get(Course.class, thisId);
	}

	@Override
	public void updateCourse(Course course) {
		course.setUpdateTime(new Date(System.currentTimeMillis()));
		getHibernateTemplate().update(course);
		
	}

	@Override
	public void deleteCourse(Integer thisId) {
		Course course = getHibernateTemplate().get(Course.class, thisId);
		getHibernateTemplate().delete(course);
		
	}

	@Override
	public List<Course> findCourseByDetachedCriteria(DetachedCriteria dc) {
		
		return (List<Course>) getHibernateTemplate().findByCriteria(dc);
	}

	
}
