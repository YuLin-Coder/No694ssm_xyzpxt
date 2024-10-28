package com.entity;

import com.util.VeDate;

public class Applys {
	private String applysid = "A" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 用户
	private String jobsid;// 招聘职位
	private String url;// 简历文件
	private String addtime;// 投递日期
	private String status;// 状态
	private String username;// 映射数据
	private String title;// 映射数据
	private String senderid;

	public String getSenderid() {
		return senderid;
	}

	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}

	public String getApplysid() {
		return applysid;
	}

	public void setApplysid(String applysid) {
		this.applysid = applysid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getJobsid() {
		return this.jobsid;
	}

	public void setJobsid(String jobsid) {
		this.jobsid = jobsid;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Applys [applysid=" + this.applysid + ", usersid=" + this.usersid + ", jobsid=" + this.jobsid + ", url=" + this.url
				+ ", addtime=" + this.addtime + ", status=" + this.status + ", username=" + this.username + ", title=" + this.title + "]";
	}

}
