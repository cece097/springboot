package shanshan.spring.boot.jpa.service;

import java.util.List;

import shanshan.spring.boot.common.model.UserModel;


/**
 * 用户相关接口
 * @author zss
 * @date 2017年4月20日
 */
public interface UserService {
	
	/**
	 * 通过id获取用户信息
	 * @param id
	 * @return
	 */
	public UserModel getById(String id);
	
	/**
	 * 通过名字获取用户
	 * @param name
	 * @return
	 */
	public List<UserModel> getByName(String name);
}
