package com.zhiyou100.ssh.video.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.ssh.video.dao.SubjectDao;
import com.zhiyou100.ssh.video.model.Subject;
@SuppressWarnings("all")
public class SubjectDaoImpl extends HibernateDaoSupport implements SubjectDao {

	@Override
	public List<Subject> findAllSubject() {
		
		return (List<Subject>) getHibernateTemplate().find("from Subject");
	}

	@Override
	public Subject findSubjectById(Integer subjectId) {
		
		return getHibernateTemplate().get(Subject.class, subjectId);
	}

}
