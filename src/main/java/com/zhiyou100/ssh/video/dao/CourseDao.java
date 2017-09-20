package com.zhiyou100.ssh.video.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh.video.model.Course;

public interface CourseDao {

	List<Course> getAllCourse();

	int findAllCourseCount(DetachedCriteria dc);

	List<Course> findAllCourse(DetachedCriteria dc, Integer page);

	void addCourse(Course course);

	Course findCourseById(Integer thisId);

	void updateCourse(Course course);

	void deleteCourse(Integer thisId);

	List<Course> findCourseByDetachedCriteria(DetachedCriteria dc);


}
