package com.zhiyou100.ssh.video.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh.video.dao.AdminDao;
import com.zhiyou100.ssh.video.model.Admin;
import com.zhiyou100.ssh.video.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
	AdminDao ad;

	@Override
	public Admin findAdminByNameAndPwd(DetachedCriteria dc) {
		return ad.findAdminByNameAndPwd(dc);
	}
}
