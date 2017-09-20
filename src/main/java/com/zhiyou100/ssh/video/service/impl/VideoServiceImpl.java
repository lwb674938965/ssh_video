package com.zhiyou100.ssh.video.service.impl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh.video.dao.VideoDao;
import com.zhiyou100.ssh.video.model.Page;
import com.zhiyou100.ssh.video.model.Video;
import com.zhiyou100.ssh.video.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService {
	@Autowired
	VideoDao vd;

	@Override
	public Page<Video> findAllVideoByConditions(DetachedCriteria dc, Integer currentPage) {
		Page<Video> page = new Page<>();
		page.setPage(currentPage);
		page.setSize(5);
		page.setTotal(vd.findAllVideoConuts(dc));
		page.setRows(vd.findAllVideoByConditions(dc,currentPage));
		return page;
	}

	@Override
	public void addVideo(Video video) {
		vd.addVideo(video);
		
	}

	@Override
	public Video findVideoById(Integer thisId) {
		
		return vd.findVideoById(thisId);
	}

	@Override
	public void updateVideo(Video video) {
		vd.updateVideo(video);
		
	}

	@Override
	public void deleteVideo(Integer thisId) {
		vd.deleteVideo(thisId);
		
	}

	@Override
	public void deleteMany(Integer[] rowCheck) {
		vd.deleteMany(rowCheck);
		
	}

	@Override
	public void updateVideoPlayTimes(Video video) {
		vd.updateVideoPlayTimes(video);
		
	}

	@Override
	public List<Video> findVideoByDetachedCriteria(DetachedCriteria dc) {
		
		return vd.findVideoByDetachedCriteria(dc);
	}

	

	

}
