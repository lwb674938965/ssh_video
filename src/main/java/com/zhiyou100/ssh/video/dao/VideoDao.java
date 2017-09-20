package com.zhiyou100.ssh.video.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh.video.model.Video;

public interface VideoDao {


	int findAllVideoConuts(DetachedCriteria dc);

	List<Video> findAllVideoByConditions(DetachedCriteria dc, Integer currentPage);

	void addVideo(Video video);

	Video findVideoById(Integer thisId);

	void updateVideo(Video video);

	void deleteVideo(Integer thisId);

	void deleteMany(Integer[] rowCheck);

	void updateVideoPlayTimes(Video video);

	List<Video> findVideoByDetachedCriteria(DetachedCriteria dc);


}
