package com.zhiyou100.ssh.video.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh.video.model.Course;
import com.zhiyou100.ssh.video.model.Page;

public interface CourseService {

	List<Course> getAllCourse();

	Page<Course> findAllCourse(DetachedCriteria dc, Integer page);

	void addCourse(Course course);

	Course findCourseById(Integer thisId);

	void updateCourse(Course course);

	void deleteCourse(Integer thisId);

	List<Course> findCourseByDetachedCriteria(DetachedCriteria dc);


}
