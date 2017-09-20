package com.zhiyou100.ssh.video.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh.video.dao.FrontUserDao;
import com.zhiyou100.ssh.video.model.User;
import com.zhiyou100.ssh.video.service.FrontUserService;
@Service
public class FrontUserServiceImpl implements FrontUserService {
	@Autowired
	FrontUserDao fd;

	@Override
	public User findUserByDetachedCriteria(DetachedCriteria dc) {
		
		return fd.findUserByDetachedCriteria(dc);
	}

	@Override
	public void addUser(User user) {
		fd.addUser(user);
		
	}

	@Override
	public User updateUser(User user) {
		
		return fd.updateUser(user);
	}

	@Override
	public User updateHeadImg(String nn, Integer thisId) {
		
		return fd.updateHeadImg(nn,thisId);
	}

	@Override
	public User updatePassword(String newPassword, Integer thisId) {
		return fd.updatePassword(newPassword,thisId);
	}

	@Override
	public void addCaptcha(User user, Integer code) {
		fd.addCaptcha(user,code);
		
	}

	@Override
	public void resetPassword(User user) {
		fd.resetPassword(user);
		
	}

}
