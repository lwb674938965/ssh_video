package com.zhiyou100.ssh.video.web.action.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh.video.model.Course;
import com.zhiyou100.ssh.video.model.Page;
import com.zhiyou100.ssh.video.model.Result;
import com.zhiyou100.ssh.video.model.Speaker;
import com.zhiyou100.ssh.video.model.Video;
import com.zhiyou100.ssh.video.model.VideoAnalysis;
import com.zhiyou100.ssh.video.service.CourseService;
import com.zhiyou100.ssh.video.service.SpeakerService;
import com.zhiyou100.ssh.video.service.VideoService;

@Controller("VideoAction")
@Scope("prototype")
@SuppressWarnings("all")
public class AdminVideoAction extends ActionSupport implements ModelDriven<Video>{
	
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	
	private String video_title;
	
	private Integer speaker_id;
	
	private Integer course_id;
	
	private Integer page;
	
	private Video video = new Video();
	
	private Integer thisId;
	
	private Result result;
	
	private Integer [] rowCheck;
	
	
	
	
	
	
	
	public Integer[] getRowCheck() {
		return rowCheck;
	}
	public void setRowCheck(Integer[] rowCheck) {
		this.rowCheck = rowCheck;
	}
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
	public String getVideo_title() {
		return video_title;
	}
	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}
	public Integer getSpeaker_id() {
		return speaker_id;
	}
	public void setSpeaker_id(Integer speaker_id) {
		this.speaker_id = speaker_id;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	@Override
	public Video getModel() {
		
		return video;
	}
	
	public String videoList(){
		System.out.println(11111);
		page=page==null?1:page;
		speaker_id=speaker_id==null?0:speaker_id;
		course_id=course_id==null?0:course_id;
		video_title=video_title==null?"":video_title;
		//System.out.println(video_title+"---"+speaker_id+"---"+course_id+"---"+page);
		DetachedCriteria dc = DetachedCriteria.forClass(Video.class);
		dc.add(Restrictions.like("videoTitle", video_title, MatchMode.ANYWHERE));
		if(speaker_id != 0){
			dc.add(Restrictions.eq("speaker.id", speaker_id));
		}
		if(course_id != 0){
			dc.add(Restrictions.eq("course.id", course_id));
		}
		Page<Video> page1 = vs.findAllVideoByConditions(dc,page);
		List<Speaker> speakerList = ss.getAllSpeaker();
		List<Course> courseList = cs.getAllCourse();
		//System.out.println(page1);
		ActionContext.getContext().put("page1",page1);
		ActionContext.getContext().put("speakerList",speakerList);
		ActionContext.getContext().put("courseList",courseList);
		ActionContext.getContext().put("speaker_id",speaker_id);
		ActionContext.getContext().put("course_id",course_id);
		ActionContext.getContext().put("video_title",video_title);
		return "success";
	}
	
	
	public String addVideoView(){	
		List<Speaker> speakerList = ss.getAllSpeaker();
		List<Course> courseList = cs.getAllCourse();
		ActionContext.getContext().put("addspeakerList",speakerList);
		ActionContext.getContext().put("addcourseList",courseList);
		return "addVideoView";
	}
	public String addVideo(){	
		System.out.println(video);
		Speaker speaker = new Speaker();
		Course course = new Course();
		speaker.setId(video.getSpeakerId());
		course.setId(video.getCourseId());
		video.setSpeaker(speaker);
		video.setCourse(course);
		vs.addVideo(video);
		return "videoList";
	}
	public String editVideoView(){	
		System.out.println(thisId+"--"+page);
		Video video = vs.findVideoById(thisId);
		System.out.println(video);
		List<Speaker> editspeakerList = ss.getAllSpeaker();
		List<Course> editcourseList = cs.getAllCourse();
		ActionContext.getContext().put("editspeakerList",editspeakerList);
		ActionContext.getContext().put("editcourseList",editcourseList);
		ActionContext.getContext().put("video",video);
		ActionContext.getContext().put("page",page);
		return "editVideoView";
	}
	
	public String editVideo(){	
		System.out.println(video);
		Speaker speaker = new Speaker();
		Course course = new Course();
		speaker.setId(video.getSpeakerId());
		course.setId(video.getCourseId());
		video.setSpeaker(speaker);
		video.setCourse(course);
		vs.updateVideo(video);
		return "videoList";
	}
	/*public String deleteVideo(){
		result = new Result();
		System.out.println(thisId);
		vs.deleteVideo(thisId);
		result.setOrSuccess(true);
		result.setMessage("删除成功");
		return "success";
	}*/
	
	public String deleteMany(){		
		System.out.println(Arrays.toString(rowCheck));
		System.out.println(page);
		vs.deleteMany(rowCheck);
		return "videoList";
	}
	public String videoAnalysis(){
		StringBuffer datas = new StringBuffer();
		StringBuffer times = new StringBuffer();
		List<Course> list = cs.getAllCourse();
		Integer i = 0;
		Integer k = 0;
		for(Course li: list){
			 i++;
			datas.append(li.getCourseName());
			datas.append(",");
			Integer num = 0;
			for(Video vd:li.getVideoSet()){
				//System.out.println(vd.getVideoPlayTimes());
				k = li.getVideoSet().size();
				num=num+vd.getVideoPlayTimes();
			}
			Integer avg = num/k;
			times.append(avg);
			times.append(",");
		}
		String time = times.substring(0, times.length()-1);
		String data = datas.substring(0, datas.length()-1);
		//System.out.println(data);
		//System.out.println(time);
		ActionContext.getContext().put("data",data);
		ActionContext.getContext().put("time",time);
		return "videoAnalysis";
	}
	
	
}
