package com.zhiyou100.ssh.video.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh.video.model.Admin;

public interface AdminDao {

	Admin findAdminByNameAndPwd(DetachedCriteria dc);

}
