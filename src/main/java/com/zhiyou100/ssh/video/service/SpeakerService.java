package com.zhiyou100.ssh.video.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh.video.model.Page;
import com.zhiyou100.ssh.video.model.Speaker;

public interface SpeakerService {

	List<Speaker> getAllSpeaker();

	Page<Speaker> findAllSpeaker(DetachedCriteria dc, Integer page);

	void addSpeaker(Speaker speaker);

	Speaker findSpeakerById(Integer thisId);

	void updateSpeaker(Speaker speaker);

	void deleteSpeaker(Integer thisId);


}
