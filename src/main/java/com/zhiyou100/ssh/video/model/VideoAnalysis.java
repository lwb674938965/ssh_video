package com.zhiyou100.ssh.video.model;

public class VideoAnalysis {
	
	
	private Integer id;
	private String courseName;
	private Integer avgTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getAvgTime() {
		return avgTime;
	}
	public void setAvgTime(Integer avgTime) {
		this.avgTime = avgTime;
	}
	@Override
	public String toString() {
		return "VideoAnalysis [id=" + id + ", courseName=" + courseName + ", avgTime=" + avgTime + "]";
	}

}
