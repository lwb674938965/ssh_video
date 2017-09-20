package com.zhiyou100.ssh.video.web.action.front;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhiyou100.ssh.video.model.Course;
import com.zhiyou100.ssh.video.model.Subject;
import com.zhiyou100.ssh.video.service.CourseService;
import com.zhiyou100.ssh.video.service.SubjectService;

@Controller("FrontCourseAction")
@Scope("prototype")
@SuppressWarnings("all")
public class FrontCourseAction extends ActionSupport{
	
	@Autowired
	SubjectService ss;
	@Autowired
	CourseService cs;
	
	private Integer subjectId;
	
	
	
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}


	public String index(){
		System.out.println(subjectId);
		DetachedCriteria dc = DetachedCriteria.forClass(Course.class);
		dc.add(Restrictions.eq("subject.id", subjectId));
		Subject subject = ss.findSubjectById(subjectId);
		System.out.println(subject);
		List<Course> courses = cs.findCourseByDetachedCriteria(dc);
		System.out.println(courses);
		for(Course cc:courses){
			System.out.println(cc.getVideoSet());
		}
		ActionContext.getContext().put("courses", courses);
		ActionContext.getContext().put("subjectId", subjectId);
		ActionContext.getContext().put("subject", subject);
		return "success";
	}

}
