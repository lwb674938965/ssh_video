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
import com.zhiyou100.ssh.video.model.Video;
import com.zhiyou100.ssh.video.service.CourseService;
import com.zhiyou100.ssh.video.service.SubjectService;
import com.zhiyou100.ssh.video.service.VideoService;

@Controller("FrontVideoAction")
@Scope("prototype")
@SuppressWarnings("all")
public class FrontVideoAction extends ActionSupport{
	
	
	@Autowired
	SubjectService ss;
	@Autowired
	CourseService cs;
	@Autowired
	VideoService vs;
	
	private Integer subjectId;
	private Integer videoId;
	
	
	
	public Integer getVideoId() {
		return videoId;
	}
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}


	public String index(){
		System.out.println(videoId+"------"+subjectId);
		DetachedCriteria dc = DetachedCriteria.forClass(Course.class);
		dc.add(Restrictions.eq("subject.id", subjectId));
		Subject subject = ss.findSubjectById(subjectId);
		ActionContext.getContext().put("videoId", videoId);
		ActionContext.getContext().put("subject", subject);
		return "success";
	}
	public String videoData(){
		System.out.println(videoId);
		Video video = vs.findVideoById(videoId);
		DetachedCriteria dc = DetachedCriteria.forClass(Course.class);
		dc.add(Restrictions.idEq(video.getCourse().getId()));
		List<Course> list = cs.findCourseByDetachedCriteria(dc);
		if(list.isEmpty()){
			ActionContext.getContext().put("list",null);
			ActionContext.getContext().put("video", video);
			return "content";
		}
		ActionContext.getContext().put("list",list.get(0));
		ActionContext.getContext().put("video", video);
		return "content";
	}
	public String state(){
		Video video = vs.findVideoById(videoId);
		video.setVideoPlayTimes(video.getVideoPlayTimes()+1);
		vs.updateVideoPlayTimes(video);

		return "content";
	}

}
