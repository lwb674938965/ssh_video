package com.zhiyou100.ssh.video.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh.video.model.Speaker;

public interface SpeakerDao {

	List<Speaker> getAllSpeaker();

	int findAllSpeakerCount(DetachedCriteria dc);

	List<Speaker> findAllSpeaker(DetachedCriteria dc, Integer page);

	void addSpeaker(Speaker speaker);

	Speaker findSpeakerById(Integer thisId);

	void updateSpeaker(Speaker speaker);

	void deleteSpeaker(Integer thisId);

}
