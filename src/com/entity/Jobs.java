package com.entity;

import com.util.VeDate;

public class Jobs {
	private String jobsid = "J" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 发布人
	private String title;// 标题
	private String cateid;// 职业类型
	private String num;// 招聘人数
	private String asignnum;// 报名人数
	private String salary;// 薪资
	private String addtime;// 发布日期
	private String hits;// 点击数
	private String contents;// 职务介绍
	private String status;// 状态
	private String realname;// 映射数据
	private String catename;// 映射数据

	public String getJobsid() {
		return jobsid;
	}

	public void setJobsid(String jobsid) {
		this.jobsid = jobsid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getAsignnum() {
		return this.asignnum;
	}

	public void setAsignnum(String asignnum) {
		this.asignnum = asignnum;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Jobs [jobsid=" + this.jobsid + ", usersid=" + this.usersid + ", title=" + this.title + ", cateid=" + this.cateid + ", num="
				+ this.num + ", asignnum=" + this.asignnum + ", salary=" + this.salary + ", addtime=" + this.addtime + ", hits=" + this.hits
				+ ", contents=" + this.contents + ", status=" + this.status + ", realname=" + this.realname + ", catename=" + this.catename
				+ "]";
	}

}
