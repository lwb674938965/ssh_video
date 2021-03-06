package com.zhiyou100.ssh.video.service;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh.video.model.User;

public interface FrontUserService {

	User findUserByDetachedCriteria(DetachedCriteria dc);

	void addUser(User user);

	User updateUser(User user);

	User updateHeadImg(String nn, Integer thisId);

	User updatePassword(String newPassword, Integer thisId);

	void addCaptcha(User user, Integer code);

	void resetPassword(User user);

}
