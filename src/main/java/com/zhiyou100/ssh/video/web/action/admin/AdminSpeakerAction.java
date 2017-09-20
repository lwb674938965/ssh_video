package com.zhiyou100.ssh.video.web.action.admin;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh.video.model.Page;
import com.zhiyou100.ssh.video.model.Result;
import com.zhiyou100.ssh.video.model.Speaker;
import com.zhiyou100.ssh.video.model.Video;
import com.zhiyou100.ssh.video.service.SpeakerService;
import com.zhiyou100.ssh.video.service.VideoService;
@Controller("SpeakerAction")
@Scope("prototype")
@SuppressWarnings("all")
public class AdminSpeakerAction extends ActionSupport implements ModelDriven<Speaker>{
	
	@Autowired
	SpeakerService ss;
	@Autowired
	VideoService vs;
	
	private String speakerNamef;
	private String speakerJobf;
	private Integer page;
	private Integer thisId;
	private Speaker speaker = new Speaker();
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
	public String getSpeakerNamef() {
		return speakerNamef;
	}
	public void setSpeakerNamef(String speakerNamef) {
		this.speakerNamef = speakerNamef;
	}
	public String getSpeakerJobf() {
		return speakerJobf;
	}
	public void setSpeakerJobf(String speakerJobf) {
		this.speakerJobf = speakerJobf;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	@Override
	public Speaker getModel() {
		
		return speaker;
	}


	public String speakerList(){
		speakerNamef=speakerNamef==null?"":speakerNamef;
		speakerJobf=speakerJobf==null?"":speakerJobf;
		page=page==null?1:page;
		//System.out.println(speakerNamef+"--"+speakerJobf+"--"+page);
		DetachedCriteria dc = DetachedCriteria.forClass(Speaker.class);
		dc.add(Restrictions.like("speakerName", speakerNamef, MatchMode.ANYWHERE)).add(Restrictions.like("speakerJob", speakerJobf, MatchMode.ANYWHERE));
		Page<Speaker> page1 = ss.findAllSpeaker(dc,page);
		ActionContext.getContext().put("page1", page1);
		ActionContext.getContext().put("speakerName", speakerNamef);
		ActionContext.getContext().put("speakerJob", speakerJobf);
		
		return "success";
	}
	public String addSpeakerView(){
		return "addSpeakerView";
	}
	public String addSpeaker(){
		ss.addSpeaker(speaker);
		return "speakerLsit";
	}
	public String editSpeakerView(){
		System.out.println(thisId);
		speaker = ss.findSpeakerById(thisId);
		//System.out.println(speaker);
		ActionContext.getContext().put("sp", speaker);
		return "editSpeakerView";
	}
	public String editSpeaker(){
		/*System.out.println(speaker);
		DetachedCriteria dc = DetachedCriteria.forClass(Video.class);
		dc.add(Restrictions.eq("speaker.id", speaker.getId()));
		List<Video> videoList = vs.findVideoByDetachedCriteria(dc);
		for(Video vd:videoList){
			speaker.getVideoSet().add(vd);;
		}*/
		ss.updateSpeaker(speaker);
		return "speakerLsit";
	}
	/*public String deleteSpeaker(){
		System.out.println(thisId);
		ss.deleteSpeaker(thisId);
		result = new Result();
		result.setMessage("删除成功");
		result.setOrSuccess(true);
		return "success";
	}*/

}
