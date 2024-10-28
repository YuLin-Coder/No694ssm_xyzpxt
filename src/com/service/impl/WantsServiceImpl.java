package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.WantsDAO;
import com.entity.Wants;
import com.service.WantsService;

@Service("wantsService")
public class WantsServiceImpl implements WantsService {
	@Autowired
	private WantsDAO wantsDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertWants(Wants wants) {
		return this.wantsDAO.insertWants(wants);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateWants(Wants wants) {
		return this.wantsDAO.updateWants(wants);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteWants(String wantsid) {
		return this.wantsDAO.deleteWants(wantsid);
	}

	@Override // 继承接口的查询全部
	public List<Wants> getAllWants() {
		return this.wantsDAO.getAllWants();
	}

	@Override // 继承接口的按条件精确查询
	public List<Wants> getWantsByCond(Wants wants) {
		return this.wantsDAO.getWantsByCond(wants);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Wants> getWantsByLike(Wants wants) {
		return this.wantsDAO.getWantsByLike(wants);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Wants getWantsById(String wantsid) {
		return this.wantsDAO.getWantsById(wantsid);
	}

}

