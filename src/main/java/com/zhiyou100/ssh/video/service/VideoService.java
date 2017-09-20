package com.zhiyou100.ssh.video.service;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh.video.model.Page;
import com.zhiyou100.ssh.video.model.Video;

public interface VideoService {

	Page<Video> findAllVideoByConditions(DetachedCriteria dc, Integer currentPage);

	void addVideo(Video video);

	Video findVideoById(Integer thisId);

	void updateVideo(Video video);

	void deleteVideo(Integer thisId);

	void deleteMany(Integer[] rowCheck);

	void updateVideoPlayTimes(Video video);

	List<Video> findVideoByDetachedCriteria(DetachedCriteria dc);


}
