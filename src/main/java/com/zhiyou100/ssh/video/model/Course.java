package com.zhiyou100.ssh.video.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Course{
    private Integer id;

    private String courseName;

    private String courseDescr;

    private Date insertTime;

    private Date updateTime;

    private Integer subjectId;
    
    private String subName;
    
    private Video vi;
    
    //private TreeSet<Video> videoSet = new TreeSet<>();
   private Set<Video> videoSet = new HashSet<>();
        
    private Subject subject;
    
    
    
    
    

    public Set<Video> getVideoSet() {
		return videoSet;
	}

	public void setVideoSet(Set<Video> videoSet) {
		this.videoSet = videoSet;
	}

	/*public TreeSet<Video> getVideoSet() {
		return videoSet;
	}

	public void setVideoSet(TreeSet<Video> videoSet) {
		this.videoSet = videoSet;
	}*/

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Video getVi() {
		return vi;
	}

	public void setVi(Video vi) {
		this.vi = vi;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

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
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseDescr() {
        return courseDescr;
    }

    public void setCourseDescr(String courseDescr) {
        this.courseDescr = courseDescr == null ? null : courseDescr.trim();
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

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDescr=" + courseDescr + ", insertTime="
				+ insertTime + ", updateTime=" + updateTime + ", subjectId=" + subjectId + ", subName=" + subName
				+ ", vi=" + vi + ", videoSet=" + videoSet + "]";
	}

	/*@Override
	public int compareTo(Video o) {
		Set<Video> videoSet2 = this.getVideoSet();
		for(Video v :videoSet2){
			if(v.getId()>o.getId()){
				return 1;
			}
		}
		return -1;
	}*/



	

	
    
    
}