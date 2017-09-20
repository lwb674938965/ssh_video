package com.zhiyou100.ssh.video.web.action.ajax;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh.video.model.Result;
import com.zhiyou100.ssh.video.model.User;
import com.zhiyou100.ssh.video.service.CourseService;
import com.zhiyou100.ssh.video.service.FrontUserService;
import com.zhiyou100.ssh.video.service.SpeakerService;
import com.zhiyou100.ssh.video.service.VideoService;
import com.zhiyou100.ssh.video.util.IdentifyingCode;
import com.zhiyou100.ssh.video.util.MD5Util;
import com.zhiyou100.ssh.video.util.MailUtil;

@Controller("AjaxAction")
@Scope("prototype")
@SuppressWarnings("all")
public class AjaxAction extends ActionSupport implements ModelDriven<User>{
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	@Autowired
	FrontUserService fs;
	
	private Result result;
	private Integer thisId;
	private String oldPassword;
	private String msg;
	
	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	

	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public Integer getThisId() {
		return thisId;
	}
	public void setThisId(Integer thisId) {
		this.thisId = thisId;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}



	public String deleteVideo(){
		//System.out.println(111);
		//System.out.println(thisId);
		result = new Result();
		vs.deleteVideo(thisId);
		result.setOrSuccess(true);
		result.setMessage("删除成功");
		//msg="success";
		return "success";
	}
	
	public String deleteSpeaker(){
		System.out.println("1111111111111");
		System.out.println(thisId);
		ss.deleteSpeaker(thisId);
		result = new Result();
		result.setMessage("删除成功");
		result.setOrSuccess(true);
		return "success";
	}
	
	public String deleteCourse(){
		//System.out.println(thisId);
		result = new Result();
		cs.deleteCourse(thisId);
		result.setMessage("1111111");
		result.setOrSuccess(true);
		return "success";
	}
	
	public String frontLogin(){
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("email", user.getEmail())).add(Restrictions.eq("password", MD5Util.getMD5(user.getPassword())));
		User us = fs.findUserByDetachedCriteria(dc);
		if(us != null){
			//System.out.println(us);
			result = new Result();
			result.setOrSuccess(true);
			ActionContext.getContext().getSession().put("_front_user", us);
			return "success";
		}
		return "index";
	}
	public String frontRegist(){
		//System.out.println(user);
		fs.addUser(user);
		System.out.println(111);
		result = new Result();
		result.setOrSuccess(true);
		return "success";
	
	}
	public String checkEmail(){
		//System.out.println(user.getEmail());
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("email", user.getEmail()));
		User u= fs.findUserByDetachedCriteria(dc);
		result = new Result();
		if(u != null){
			result.setOrSuccess(true);
			return "success";
		}
		return "success";
	}
	public String checkOldPassword(){
		//System.out.println(oldPassword+"---"+thisId);
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.idEq(thisId)).add(Restrictions.eq("password", MD5Util.getMD5(oldPassword)));
		User u= fs.findUserByDetachedCriteria(dc);
		result = new Result();
		if(u == null){
			result.setOrSuccess(true);
			return "success";
		}
		return "success";
	}
	
	public String sendMail() throws Exception{
		//System.out.println(user.getEmail());
		Integer code = IdentifyingCode.getRandomCode();
		MailUtil.send(user.getEmail(), "中国彩票福利局", ""+code);
		fs.addCaptcha(user,code);
		result = new Result();
		result.setOrSuccess(true);
		return "success";
	}

	
	
	
	
}
