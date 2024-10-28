package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Jobs;
import com.service.JobsService;
import com.entity.Users;
import com.entity.Cate;
import com.service.UsersService;
import com.service.CateService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/jobs", produces = "text/plain;charset=utf-8")
public class JobsController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private JobsService jobsService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private CateService cateService;

	// 准备添加数据
	@RequestMapping("createJobs.action")
	public String createJobs() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/addjobs";
	}

	// 添加数据
	@RequestMapping("addJobs.action")
	public String addJobs(Jobs jobs) {
		jobs.setUsersid("");
		jobs.setCateid("");
		jobs.setAddtime(VeDate.getStringDateShort());
		jobs.setHits("0");
		jobs.setStatus("");
		this.jobsService.insertJobs(jobs);
		return "redirect:/jobs/createJobs.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteJobs.action")
	public String deleteJobs(String id) {
		this.jobsService.deleteJobs(id);
		return "redirect:/jobs/getAllJobs.action";
	}

	// 批量删除数据
	@RequestMapping("deleteJobsByIds.action")
	public String deleteJobsByIds() {
		String[] ids = this.getRequest().getParameterValues("jobsid");
		if (ids != null) {
			for (String jobsid : ids) {
				this.jobsService.deleteJobs(jobsid);
			}
		}
		return "redirect:/jobs/getAllJobs.action";
	}

	// 更新数据
	@RequestMapping("updateJobs.action")
	public String updateJobs(Jobs jobs) {
		this.jobsService.updateJobs(jobs);
		return "redirect:/jobs/getAllJobs.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "已审核";
		Jobs jobs = this.jobsService.getJobsById(id);
		jobs.setStatus(status);
		this.jobsService.updateJobs(jobs);
		return "redirect:/jobs/getAllJobs.action";
	}

	// 显示全部数据
	@RequestMapping("getAllJobs.action")
	public String getAllJobs(String number) {
		List<Jobs> jobsList = this.jobsService.getAllJobs();
		PageHelper.getPage(jobsList, "jobs", null, null, 10, number, this.getRequest(), null);
		return "admin/listjobs";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryJobsByCond.action")
	public String queryJobsByCond(String cond, String name, String number) {
		Jobs jobs = new Jobs();
		if (cond != null) {
			if ("usersid".equals(cond)) {
				jobs.setUsersid(name);
			}
			if ("title".equals(cond)) {
				jobs.setTitle(name);
			}
			if ("cateid".equals(cond)) {
				jobs.setCateid(name);
			}
			if ("num".equals(cond)) {
				jobs.setNum(name);
			}
			if ("asignnum".equals(cond)) {
				jobs.setAsignnum(name);
			}
			if ("salary".equals(cond)) {
				jobs.setSalary(name);
			}
			if ("addtime".equals(cond)) {
				jobs.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				jobs.setHits(name);
			}
			if ("contents".equals(cond)) {
				jobs.setContents(name);
			}
			if ("status".equals(cond)) {
				jobs.setStatus(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.jobsService.getJobsByLike(jobs), "jobs", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryjobs";
	}

	// 按主键查询数据
	@RequestMapping("getJobsById.action")
	public String getJobsById(String id) {
		Jobs jobs = this.jobsService.getJobsById(id);
		this.getRequest().setAttribute("jobs", jobs);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/editjobs";
	}

}
