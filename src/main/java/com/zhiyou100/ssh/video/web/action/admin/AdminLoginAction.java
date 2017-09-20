package com.zhiyou100.ssh.video.web.action.admin;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh.video.model.Admin;
import com.zhiyou100.ssh.video.service.AdminService;
import com.zhiyou100.ssh.video.util.MD5Util;

@Controller("AdminAction")
@Scope("prototype")
@SuppressWarnings("all")
public class AdminLoginAction extends ActionSupport implements ModelDriven<Admin>{

	@Autowired
	AdminService as;
	
	private Admin admin = new Admin();
	

	@Override
	public Admin getModel() {
		return admin;
	}
	public String login(){
		System.out.println(1111111111);
		System.out.println(admin+"---"+MD5Util.getMD5(admin.getLogin_pwd()));
		DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
		dc.add(Restrictions.eq("login_name", admin.getLogin_name())).add(Restrictions.eq("login_pwd",MD5Util.getMD5(admin.getLogin_pwd())));
		Admin ad = as.findAdminByNameAndPwd(dc);
		if(ad != null ){
			ActionContext.getContext().getSession().put("ad", ad);
			return "videoList";
		}
		return "success";
	}
	public String exitController(){
		ActionContext.getContext().getSession().remove("ad");
		return "admin";
	}
	
}
