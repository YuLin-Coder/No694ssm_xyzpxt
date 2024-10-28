package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.UsersService;
import com.service.BannerService;
import com.service.ArticleService;
import com.service.CateService;
import com.service.JobsService;
import com.service.WantsService;
import com.service.ApplysService;
import com.service.ComplainsService;
import com.entity.Users;
import com.entity.Banner;
import com.entity.Article;
import com.entity.Cate;
import com.entity.Jobs;
import com.entity.Wants;
import com.entity.Applys;
import com.entity.Complains;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexController extends BaseController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CateService cateService;
	@Autowired
	private JobsService jobsService;
	@Autowired
	private WantsService wantsService;
	@Autowired
	private ApplysService applysService;
	@Autowired
	private ComplainsService complainsService;

	// TODO Auto-generated method stub
	// 公共方法 提供公共查询数据
	private void front() {
		this.getRequest().setAttribute("title", "求职招聘系统");
		List<Banner> bannerList = this.bannerService.getAllBanner();
		this.getRequest().setAttribute("bannerList", bannerList);
	}

	// 首页显示
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Banner> bannerList = this.bannerService.getAllBanner();
		List<Banner> frontList = new ArrayList<Banner>();
		for (Banner banner : bannerList) {
			List<Article> articleList = this.articleService.getArticleByBanner(banner.getBannerid());
			banner.setArticleList(articleList);
			frontList.add(banner);
		}
		this.getRequest().setAttribute("frontList", frontList);
		List<Article> topList = this.articleService.getTopArticle();
		List<Article> favList = this.articleService.getFlvArticle();
		this.getRequest().setAttribute("topList", topList);
		this.getRequest().setAttribute("favList", favList);
		return "users/index";
	}

	// 新闻公告
	@RequestMapping("article.action")
	public String article(String id, String number) {
		this.front();
		Article article = new Article();
		article.setBannerid(id);
		List<Article> articleList = this.articleService.getArticleByCond(article);
		PageHelper.getIndexPage(articleList, "article", "article", id, 10, number, this.getRequest());
		Banner banner = this.bannerService.getBannerById(id);
		this.getRequest().setAttribute("banner", banner);
		return "users/article";
	}

	// 阅读公告
	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	// 招聘信息
	@RequestMapping("jobs.action")
	public String jobs(String number) {
		this.front();
		Jobs jobs = new Jobs();
		jobs.setStatus("已审核");
		List<Jobs> jobsList = this.jobsService.getJobsByCond(jobs);
		PageHelper.getIndexPage(jobsList, "jobs", "jobs", null, 10, number, this.getRequest());
		return "users/jobs";
	}

	// 招聘信息详情
	@RequestMapping("jobsDetail.action")
	public String jobsDetail(String id) {
		this.front();
		Jobs jobs = this.jobsService.getJobsById(id);
		jobs.setHits("" + (Integer.parseInt(jobs.getHits()) + 1));
		this.jobsService.updateJobs(jobs);
		this.getRequest().setAttribute("jobs", jobs);
		return "users/jobsDetail";
	}

	// 求职信息
	@RequestMapping("wants.action")
	public String wants(String number) {
		this.front();
		Wants wants = new Wants();
		wants.setStatus("已审核");
		List<Wants> wantsList = this.wantsService.getWantsByCond(wants);
		PageHelper.getIndexPage(wantsList, "wants", "wants", null, 10, number, this.getRequest());
		return "users/wants";
	}

	// 求职信息详情
	@RequestMapping("wantsDetail.action")
	public String wantsDetail(String id) {
		this.front();
		Wants wants = this.wantsService.getWantsById(id);
		wants.setHits("" + (Integer.parseInt(wants.getHits()) + 1));
		this.wantsService.updateWants(wants);
		this.getRequest().setAttribute("wants", wants);
		return "users/wantsDetail";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users users = usersList.get(0);
			if ("锁定".equals(users.getStatus())) {
				this.getSession().setAttribute("message", "账户被锁定");
				return "redirect:/index/preLogin.action";
			}
			if (password.equals(users.getPassword())) {
				this.getSession().setAttribute("userid", users.getUsersid());
				this.getSession().setAttribute("username", users.getUsername());
				this.getSession().setAttribute("role", users.getRole());
				this.getSession().setAttribute("users", users);
				return "redirect:/index/index.action";
			} else {
				this.getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
			}
		}
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			users.setStatus("锁定");
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		return "redirect:/index/index.action";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		this.getSession().setAttribute("message", "修改成功");
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		this.getSession().setAttribute("message", "修改成功");
		return "redirect:/index/userinfo.action";
	}

	@RequestMapping("preComplains.action")
	public String preComplains() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addComplains";
	}

	@RequestMapping("addComplains.action")
	public String addComplains(Complains complains) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		complains.setAddtime(VeDate.getStringDateShort());
		complains.setStatus("未回复");
		complains.setUsersid(userid);
		this.complainsService.insertComplains(complains);
		return "redirect:/index/preComplains.action";
	}

	@RequestMapping("myComplains.action")
	public String myComplains(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Complains complains = new Complains();
		complains.setUsersid(userid);
		List<Complains> complainsList = this.complainsService.getComplainsByCond(complains);
		PageHelper.getIndexPage(complainsList, "complains", "myComplains", null, 10, number, this.getRequest());
		return "users/myComplains";
	}

	@RequestMapping("preWants.action")
	public String preWants() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "users/addWants";
	}

	@RequestMapping("addWants.action")
	public String addWants(Wants wants) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		wants.setAddtime(VeDate.getStringDateShort());
		wants.setStatus("待审核");
		wants.setUsersid(userid);
		wants.setHits("0");
		this.wantsService.insertWants(wants);
		return "redirect:/index/myWants.action";
	}

	@RequestMapping("myWants.action")
	public String myWants(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Wants wants = new Wants();
		wants.setUsersid(userid);
		List<Wants> wantsList = this.wantsService.getWantsByCond(wants);
		PageHelper.getIndexPage(wantsList, "wants", "myWants", null, 10, number, this.getRequest());
		return "users/myWants";
	}

	@RequestMapping("preJobs.action")
	public String preJobs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "users/addJobs";
	}

	@RequestMapping("addJobs.action")
	public String addJobs(Jobs jobs) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		jobs.setAddtime(VeDate.getStringDateShort());
		jobs.setStatus("待审核");
		jobs.setUsersid(userid);
		jobs.setHits("0");
		jobs.setAsignnum("0");
		this.jobsService.insertJobs(jobs);
		return "redirect:/index/myJobs.action";
	}

	@RequestMapping("myJobs.action")
	public String myJobs(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Jobs jobs = new Jobs();
		jobs.setUsersid(userid);
		List<Jobs> jobsList = this.jobsService.getJobsByCond(jobs);
		PageHelper.getIndexPage(jobsList, "jobs", "myJobs", null, 10, number, this.getRequest());
		return "users/myJobs";
	}

	@RequestMapping("preApplys.action")
	public String preApplys(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Jobs jobs = this.jobsService.getJobsById(id);
		this.getRequest().setAttribute("jobs", jobs);
		return "users/addApplys";
	}

	@RequestMapping("addApplys.action")
	public String addApplys(Applys applys) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Applys x = new Applys();
		x.setUsersid(userid);
		x.setJobsid(applys.getJobsid());
		List<Applys> list = this.applysService.getApplysByCond(x);
		if (list.size() == 0) {
			applys.setAddtime(VeDate.getStringDateShort());
			applys.setStatus("待审核");
			applys.setUsersid(userid);
			this.applysService.insertApplys(applys);
			Jobs jobs = this.jobsService.getJobsById(applys.getJobsid());
			jobs.setAsignnum("" + (Integer.parseInt(jobs.getAsignnum())));
			this.jobsService.updateJobs(jobs);
		} else {
			this.getSession().setAttribute("message", "不能重复报名");
		}
		return "redirect:/index/myApplys.action";
	}

	@RequestMapping("myApplys.action")
	public String myApplys(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Applys applys = new Applys();
		applys.setUsersid(userid);
		List<Applys> applysList = this.applysService.getApplysByCond(applys);
		PageHelper.getIndexPage(applysList, "applys", "myApplys", null, 10, number, this.getRequest());
		return "users/myApplys";
	}

	@RequestMapping("myApplysx.action")
	public String myApplysx(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Applys applys = new Applys();
		applys.setSenderid(userid);
		List<Applys> applysList = this.applysService.getApplysByCond(applys);
		PageHelper.getIndexPage(applysList, "applys", "myApplysx", null, 10, number, this.getRequest());
		return "users/myApplysx";
	}

	@RequestMapping("accept.action")
	public String accept(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Applys applys = this.applysService.getApplysById(id);
		applys.setStatus("通过审核");
		this.applysService.updateApplys(applys);
		return "redirect:/index/myApplysx.action";
	}

	@RequestMapping("refuse.action")
	public String refuse(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Applys applys = this.applysService.getApplysById(id);
		applys.setStatus("拒绝申请");
		this.applysService.updateApplys(applys);
		return "redirect:/index/myApplysx.action";
	}
	// TODO Auto-generated method stub
}
