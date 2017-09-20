package com.zhiyou100.ssh.video.web.action.admin;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh.video.model.Course;
import com.zhiyou100.ssh.video.model.Page;
import com.zhiyou100.ssh.video.model.Result;
import com.zhiyou100.ssh.video.model.Subject;
import com.zhiyou100.ssh.video.model.Video;
import com.zhiyou100.ssh.video.service.CourseService;
import com.zhiyou100.ssh.video.service.SubjectService;
import com.zhiyou100.ssh.video.service.VideoService;

@Controller("CourseAction")
@Scope("prototype")
@SuppressWarnings("all")
public class AdminCourseAction extends ActionSupport implements ModelDriven<Course>{
	@Autowired
	CourseService cs;
	@Autowired
	SubjectService ss;
	@Autowired
	VideoService vs;
	private Integer page;
	private Course course = new Course();
	private Integer thisId;
	private Result result;
	
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public Integer getThisId() {
		return thisId;
	}
	public void setThisId(Integer thisId) {
		this.thisId = thisId;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	@Override
	public Course getModel() {
		return course;
	}

	
	public String courseList(){
		page=page==null?1:page;
		DetachedCriteria dc = DetachedCriteria.forClass(Course.class);
		Page<Course> page1 = cs.findAllCourse(dc,page);
		//System.out.println(page1);
		ActionContext.getContext().put("page1", page1);
		return "success";
	}
	public String addCourseView(){
		List<Subject> subjectList = ss.findAllSubject();
		ActionContext.getContext().put("addSubjectList", subjectList);
		return "addCourseView";
	}
	public String addCourse(){
		Subject subject = new Subject();
		subject.setId(course.getSubjectId());
		//System.out.println(course);
		course.setSubject(subject);
		cs.addCourse(course);
		return "courseList";
	}
	public String editCourseView(){
		//System.out.println(thisId);
		Course course = cs.findCourseById(thisId);
		//System.out.println(course);
		List<Subject> subjectList = ss.findAllSubject();
		ActionContext.getContext().put("editSubjectList", subjectList);
		ActionContext.getContext().put("course", course);
		return "editCourseView";
	}
	public String editCourse(){
		Subject subject = new Subject();
		subject.setId(course.getSubjectId());
		course.setSubject(subject);
		cs.updateCourse(course);
		return "courseList";
	}
	/*public String deleteCourse(){
		System.out.println(thisId);
		result = new Result();
		cs.deleteCourse(thisId);
		result.setMessage("1111111");
		result.setOrSuccess(true);
		return "success";
	}*/
	

}
