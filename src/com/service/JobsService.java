package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Jobs;
@Service("jobsService")
public interface JobsService {
	// 插入数据 调用jobsDAO里的insertJobs配置
	public int insertJobs(Jobs jobs);

	// 更新数据 调用jobsDAO里的updateJobs配置
	public int updateJobs(Jobs jobs);

	// 删除数据 调用jobsDAO里的deleteJobs配置
	public int deleteJobs(String jobsid);

	// 查询全部数据 调用jobsDAO里的getAllJobs配置
	public List<Jobs> getAllJobs();

	// 按照Jobs类里面的字段名称精确查询 调用jobsDAO里的getJobsByCond配置
	public List<Jobs> getJobsByCond(Jobs jobs);

	// 按照Jobs类里面的字段名称模糊查询 调用jobsDAO里的getJobsByLike配置
	public List<Jobs> getJobsByLike(Jobs jobs);

	// 按主键查询表返回单一的Jobs实例 调用jobsDAO里的getJobsById配置
	public Jobs getJobsById(String jobsid);

}

