package com.zhiyou100.ssh.video.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh.video.dao.CourseDao;
import com.zhiyou100.ssh.video.model.Course;
import com.zhiyou100.ssh.video.model.Page;
import com.zhiyou100.ssh.video.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao cd;

	@Override
	public List<Course> getAllCourse() {
		
		return cd.getAllCourse();
	}

	@Override
	public Page<Course> findAllCourse(DetachedCriteria dc, Integer page) {
		Page<Course> page1 = new Page<>();
		page1.setPage(page);
		page1.setSize(5);
		page1.setTotal(cd.findAllCourseCount(dc));
		page1.setRows(cd.findAllCourse(dc,page));
		return page1;
	}

	@Override
	public void addCourse(Course course) {
		cd.addCourse(course);
		
	}

	@Override
	public Course findCourseById(Integer thisId) {
		
		return cd.findCourseById(thisId);
	}

	@Override
	public void updateCourse(Course course) {
		cd.updateCourse(course);
		
	}

	@Override
	public void deleteCourse(Integer thisId) {
		cd.deleteCourse(thisId);
		
	}

	@Override
	public List<Course> findCourseByDetachedCriteria(DetachedCriteria dc) {
		return cd.findCourseByDetachedCriteria(dc);
	}

	
}
