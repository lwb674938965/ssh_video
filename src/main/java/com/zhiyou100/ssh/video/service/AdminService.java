package com.zhiyou100.ssh.video.service;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh.video.model.Admin;

public interface AdminService {

	Admin findAdminByNameAndPwd(DetachedCriteria dc);

}
