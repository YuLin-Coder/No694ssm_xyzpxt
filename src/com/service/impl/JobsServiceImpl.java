package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.JobsDAO;
import com.entity.Jobs;
import com.service.JobsService;

@Service("jobsService")
public class JobsServiceImpl implements JobsService {
	@Autowired
	private JobsDAO jobsDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertJobs(Jobs jobs) {
		return this.jobsDAO.insertJobs(jobs);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateJobs(Jobs jobs) {
		return this.jobsDAO.updateJobs(jobs);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteJobs(String jobsid) {
		return this.jobsDAO.deleteJobs(jobsid);
	}

	@Override // 继承接口的查询全部
	public List<Jobs> getAllJobs() {
		return this.jobsDAO.getAllJobs();
	}

	@Override // 继承接口的按条件精确查询
	public List<Jobs> getJobsByCond(Jobs jobs) {
		return this.jobsDAO.getJobsByCond(jobs);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Jobs> getJobsByLike(Jobs jobs) {
		return this.jobsDAO.getJobsByLike(jobs);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Jobs getJobsById(String jobsid) {
		return this.jobsDAO.getJobsById(jobsid);
	}

}

