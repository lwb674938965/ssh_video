package com.zhiyou100.ssh.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh.video.dao.SubjectDao;
import com.zhiyou100.ssh.video.model.Subject;
import com.zhiyou100.ssh.video.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectDao sd;

	@Override
	public List<Subject> findAllSubject() {
		
		return sd.findAllSubject();
	}

	@Override
	public Subject findSubjectById(Integer subjectId) {
		
		return sd.findSubjectById(subjectId);
	}

}
