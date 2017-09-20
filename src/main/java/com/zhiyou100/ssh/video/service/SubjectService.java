package com.zhiyou100.ssh.video.service;

import java.util.List;

import com.zhiyou100.ssh.video.model.Subject;

public interface SubjectService {

	List<Subject> findAllSubject();

	Subject findSubjectById(Integer subjectId);

}
