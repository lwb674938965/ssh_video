package com.zhiyou100.ssh.video.web.action.front;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh.video.model.User;
import com.zhiyou100.ssh.video.service.FrontUserService;
import com.zhiyou100.ssh.video.util.IdentifyingCode;
import com.zhiyou100.ssh.video.util.MD5Util;
import com.zhiyou100.ssh.video.util.MailUtil;
import com.zhiyou100.ssh.video.util.PicSubUtil;

@Controller("FrontUserAction")
@Scope("prototype")
@SuppressWarnings("all")
public class FrontUserAction extends ActionSupport implements ModelDriven<User>{
	@Autowired
	FrontUserService fs;
	
	private User user = new User();
	private Integer thisId;
	private File image_file;
	private String image_fileFileName;
	private String newPassword;
	
	
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public File getImage_file() {
		return image_file;
	}
	public void setImage_file(File image_file) {
		this.image_file = image_file;
	}
	public String getImage_fileFileName() {
		return image_fileFileName;
	}
	public void setImage_fileFileName(String image_fileFileName) {
		this.image_fileFileName = image_fileFileName;
	}
	public Integer getThisId() {
		return thisId;
	}
	public void setThisId(Integer thisId) {
		this.thisId = thisId;
	}

	@Override
	public User getModel() {
		return user;
	}
	public static void resetSession(User u){
		User user = (User) ActionContext.getContext().getSession().get("_front_user");
		ActionContext.getContext().getSession().put("_front_user", u);
		ActionContext.getContext().put("user", u);
		
	}
	
	public String index(){
		return SUCCESS;
	}

	public String userIndex(){
		System.out.println(thisId);
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.idEq(thisId));
		User u = fs.findUserByDetachedCriteria(dc);
		ActionContext.getContext().put("user", u);
		return "index";
	}
	public String profile(){
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.idEq(thisId));
		User u = fs.findUserByDetachedCriteria(dc);
		ActionContext.getContext().put("user", u);
		return "profile";
	}
	public String updateUser(){
		User u = fs.updateUser(user);
		resetSession(u);
		return "index";
	}
	public String avatar(){
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.idEq(thisId));
		User u = fs.findUserByDetachedCriteria(dc);
		ActionContext.getContext().put("user", u);
		return "avatar";
	}
	public String updateHeadImg() throws IOException{
		String nn ="/pic/"+UUID.randomUUID().toString().replaceAll("-", "")+"."+FilenameUtils.getExtension(image_fileFileName);
		//System.out.println(new File(image_file.getAbsolutePath()));
		FileUtils.copyFile(new File(image_file.getAbsolutePath()), new File("d:\\upload"+"\\"+nn.split("/")[2]));
		//System.out.println(nn.split("/")[2]);
		//System.out.println("d:\\upload"+"\\"+nn.split("/")[2]);
		User u = fs.updateHeadImg(nn,thisId);
		resetSession(u);
		return "index";
	}
	public String password(){
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.idEq(thisId));
		User u = fs.findUserByDetachedCriteria(dc);
		ActionContext.getContext().put("user", u);
		return "password";
	}
	public String logout(){
		ActionContext.getContext().getSession().remove("_front_user");
		return "logout";
	}
	public String updatePassword(){
		User u = fs.updatePassword(newPassword,thisId);
		ActionContext.getContext().put("message", "修改成功");
		resetSession(u);
		return "password";
	}
	public String forgetpwd(){
		
		return "forgetpwd";
	}
	public String resetPwd(){
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("email", user.getEmail())).add(Restrictions.eq("captcha", user.getCaptcha()));
		User us = fs.findUserByDetachedCriteria(dc);
		if(us != null){
			ActionContext.getContext().put("user", us);
			return "resetPwd";
		}
		ActionContext.getContext().put("warning", "验证码错误");
		ActionContext.getContext().put("user", user);
		return "forgetpwd";
	}
	public String resetPassword(){
		fs.resetPassword(user);
		return "logout";
	}
	
	
	
	
	
	
	
	
	

	
}
