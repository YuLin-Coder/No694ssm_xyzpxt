package com.entity;

import com.util.VeDate;

public class Wants {
	private String wantsid = "W" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 发布人
	private String title;// 标题
	private String cateid;// 职业类型
	private String salary;// 薪水预期
	private String addtime;// 发布日期
	private String hits;// 点击数
	private String contents;// 个人介绍
	private String status;// 状态
	private String username;// 映射数据
	private String catename;// 映射数据
	private String contact;

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getWantsid() {
		return wantsid;
	}

	public void setWantsid(String wantsid) {
		this.wantsid = wantsid;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "Wants [wantsid=" + this.wantsid + ", usersid=" + this.usersid + ", title=" + this.title + ", cateid=" + this.cateid
				+ ", salary=" + this.salary + ", addtime=" + this.addtime + ", hits=" + this.hits + ", contents=" + this.contents + ", status="
				+ this.status + ", username=" + this.username + ", catename=" + this.catename + "]";
	}

}
