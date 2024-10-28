package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Wants;
@Service("wantsService")
public interface WantsService {
	// 插入数据 调用wantsDAO里的insertWants配置
	public int insertWants(Wants wants);

	// 更新数据 调用wantsDAO里的updateWants配置
	public int updateWants(Wants wants);

	// 删除数据 调用wantsDAO里的deleteWants配置
	public int deleteWants(String wantsid);

	// 查询全部数据 调用wantsDAO里的getAllWants配置
	public List<Wants> getAllWants();

	// 按照Wants类里面的字段名称精确查询 调用wantsDAO里的getWantsByCond配置
	public List<Wants> getWantsByCond(Wants wants);

	// 按照Wants类里面的字段名称模糊查询 调用wantsDAO里的getWantsByLike配置
	public List<Wants> getWantsByLike(Wants wants);

	// 按主键查询表返回单一的Wants实例 调用wantsDAO里的getWantsById配置
	public Wants getWantsById(String wantsid);

}

