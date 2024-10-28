package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Jobs;

@Repository("jobsDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface JobsDAO {

	/**
* JobsDAO 接口 可以按名称直接调用jobs.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包jobs.xml里的insertJobs配置 返回值0(失败),1(成功)
	public int insertJobs(Jobs jobs);

	// 更新数据 调用entity包jobs.xml里的updateJobs配置 返回值0(失败),1(成功)
	public int updateJobs(Jobs jobs);

	// 删除数据 调用entity包jobs.xml里的deleteJobs配置 返回值0(失败),1(成功)
	public int deleteJobs(String jobsid);

	// 查询全部数据 调用entity包jobs.xml里的getAllJobs配置 返回List类型的数据
	public List<Jobs> getAllJobs();

	// 按照Jobs类里面的值精确查询 调用entity包jobs.xml里的getJobsByCond配置 返回List类型的数据
	public List<Jobs> getJobsByCond(Jobs jobs);

	// 按照Jobs类里面的值模糊查询 调用entity包jobs.xml里的getJobsByLike配置 返回List类型的数据
	public List<Jobs> getJobsByLike(Jobs jobs);

	// 按主键查询表返回单一的Jobs实例 调用entity包jobs.xml里的getJobsById配置
	public Jobs getJobsById(String jobsid);

}


