package com.zhiyou100.ssh.video.dao;

import java.util.List;

import com.zhiyou100.ssh.video.model.Subject;

public interface SubjectDao {

	List<Subject> findAllSubject();

	Subject findSubjectById(Integer subjectId);

}
