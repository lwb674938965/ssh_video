package com.zhiyou100.ssh.video.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh.video.dao.SpeakerDao;
import com.zhiyou100.ssh.video.model.Page;
import com.zhiyou100.ssh.video.model.Speaker;
import com.zhiyou100.ssh.video.service.SpeakerService;
@Service
public class SpeakerServiceImpl implements SpeakerService {
	@Autowired
	SpeakerDao sd;

	@Override
	public List<Speaker> getAllSpeaker() {
		
		return sd.getAllSpeaker();
	}

	@Override
	public Page<Speaker> findAllSpeaker(DetachedCriteria dc, Integer page) {
		Page<Speaker> page1 = new Page<>();
		page1.setPage(page);
		page1.setSize(5);
		page1.setTotal(sd.findAllSpeakerCount(dc));
		page1.setRows(sd.findAllSpeaker(dc,page));
		return page1;
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		sd.addSpeaker(speaker);
		
	}

	@Override
	public Speaker findSpeakerById(Integer thisId) {
		
		return sd.findSpeakerById(thisId);
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		sd.updateSpeaker(speaker);
		
	}

	@Override
	public void deleteSpeaker(Integer thisId) {
		sd.deleteSpeaker(thisId);
		
	}

}
