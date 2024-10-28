package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Wants;
import com.service.WantsService;
import com.entity.Users;
import com.entity.Cate;
import com.service.UsersService;
import com.service.CateService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/wants", produces = "text/plain;charset=utf-8")
public class WantsController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private WantsService wantsService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private CateService cateService;

	// 准备添加数据
	@RequestMapping("createWants.action")
	public String createWants() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/addwants";
	}

	// 添加数据
	@RequestMapping("addWants.action")
	public String addWants(Wants wants) {
		wants.setUsersid("");
		wants.setCateid("");
		wants.setAddtime(VeDate.getStringDateShort());
		wants.setHits("0");
		wants.setStatus("");
		this.wantsService.insertWants(wants);
		return "redirect:/wants/createWants.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteWants.action")
	public String deleteWants(String id) {
		this.wantsService.deleteWants(id);
		return "redirect:/wants/getAllWants.action";
	}

	// 批量删除数据
	@RequestMapping("deleteWantsByIds.action")
	public String deleteWantsByIds() {
		String[] ids = this.getRequest().getParameterValues("wantsid");
		if (ids != null) {
			for (String wantsid : ids) {
				this.wantsService.deleteWants(wantsid);
			}
		}
		return "redirect:/wants/getAllWants.action";
	}

	// 更新数据
	@RequestMapping("updateWants.action")
	public String updateWants(Wants wants) {
		this.wantsService.updateWants(wants);
		return "redirect:/wants/getAllWants.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "已审核";
		Wants wants = this.wantsService.getWantsById(id);
		wants.setStatus(status);
		this.wantsService.updateWants(wants);
		return "redirect:/wants/getAllWants.action";
	}

	// 显示全部数据
	@RequestMapping("getAllWants.action")
	public String getAllWants(String number) {
		List<Wants> wantsList = this.wantsService.getAllWants();
		PageHelper.getPage(wantsList, "wants", null, null, 10, number, this.getRequest(), null);
		return "admin/listwants";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryWantsByCond.action")
	public String queryWantsByCond(String cond, String name, String number) {
		Wants wants = new Wants();
		if (cond != null) {
			if ("usersid".equals(cond)) {
				wants.setUsersid(name);
			}
			if ("title".equals(cond)) {
				wants.setTitle(name);
			}
			if ("cateid".equals(cond)) {
				wants.setCateid(name);
			}
			if ("salary".equals(cond)) {
				wants.setSalary(name);
			}
			if ("addtime".equals(cond)) {
				wants.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				wants.setHits(name);
			}
			if ("contents".equals(cond)) {
				wants.setContents(name);
			}
			if ("status".equals(cond)) {
				wants.setStatus(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.wantsService.getWantsByLike(wants), "wants", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querywants";
	}

	// 按主键查询数据
	@RequestMapping("getWantsById.action")
	public String getWantsById(String id) {
		Wants wants = this.wantsService.getWantsById(id);
		this.getRequest().setAttribute("wants", wants);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/editwants";
	}

}
