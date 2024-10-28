package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Wants;

@Repository("wantsDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface WantsDAO {

	/**
* WantsDAO 接口 可以按名称直接调用wants.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包wants.xml里的insertWants配置 返回值0(失败),1(成功)
	public int insertWants(Wants wants);

	// 更新数据 调用entity包wants.xml里的updateWants配置 返回值0(失败),1(成功)
	public int updateWants(Wants wants);

	// 删除数据 调用entity包wants.xml里的deleteWants配置 返回值0(失败),1(成功)
	public int deleteWants(String wantsid);

	// 查询全部数据 调用entity包wants.xml里的getAllWants配置 返回List类型的数据
	public List<Wants> getAllWants();

	// 按照Wants类里面的值精确查询 调用entity包wants.xml里的getWantsByCond配置 返回List类型的数据
	public List<Wants> getWantsByCond(Wants wants);

	// 按照Wants类里面的值模糊查询 调用entity包wants.xml里的getWantsByLike配置 返回List类型的数据
	public List<Wants> getWantsByLike(Wants wants);

	// 按主键查询表返回单一的Wants实例 调用entity包wants.xml里的getWantsById配置
	public Wants getWantsById(String wantsid);

}


