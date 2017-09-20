package com.zhiyou100.ssh.video.model;

import java.util.Date;


public class Video{
	private Integer id;

	private String videoTitle;

	private Integer speakerId;
	
	private Speaker speaker;

	private Integer courseId;
	
	private Course course;

	private Integer videoLength;

	private String videoLengthStr;

	private String videoImageUrl;

	private String videoUrl;

	private String videoDescr;

	private Date insertTime;

	private Date updateTime;

	private Integer videoPlayTimes;




	

	

	

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getVideoLengthStr() {
    	Integer hour = this.getVideoLength() / 3600;
    	Integer min =  this.getVideoLength() % 3600 / 60;
    	Integer sec = this.getVideoLength() % 60;
		return String.format("%02d : %02d : %02d", hour,min,sec);
	}

	public void setVideoLengthStr(String videoLengthStr) {
		this.videoLengthStr = videoLengthStr;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public Integer getSpeakerId() {
		return speakerId;
	}

	public void setSpeakerId(Integer speakerId) {
		this.speakerId = speakerId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getVideoLength() {
		return videoLength;
	}

	public void setVideoLength(Integer videoLength) {
		this.videoLength = videoLength;
	}

	public String getVideoImageUrl() {
		return videoImageUrl;
	}

	public void setVideoImageUrl(String videoImageUrl) {
		this.videoImageUrl = videoImageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoDescr() {
		return videoDescr;
	}

	public void setVideoDescr(String videoDescr) {
		this.videoDescr = videoDescr;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getVideoPlayTimes() {
		return videoPlayTimes;
	}

	public void setVideoPlayTimes(Integer videoPlayTimes) {
		this.videoPlayTimes = videoPlayTimes;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", videoTitle=" + videoTitle + ", speakerId=" + speakerId + ", courseId=" + courseId
				+ ", videoLength=" + videoLength + ", videoLengthStr=" + videoLengthStr + ", videoImageUrl="
				+ videoImageUrl + ", videoUrl=" + videoUrl + ", videoDescr=" + videoDescr + ", insertTime=" + insertTime
				+ ", updateTime=" + updateTime + ", videoPlayTimes=" + videoPlayTimes + "]";
	}

	
	
	

	

	

	

	
	

}