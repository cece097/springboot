package shanshan.spring.boot.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shanshan.spring.boot.common.constant.RedisKeyConstant;
import shanshan.spring.boot.common.model.UserModel;
import shanshan.spring.boot.jpa.common.UserDTOUtil;
import shanshan.spring.boot.jpa.redis.SampleRedisUtil;
import shanshan.spring.boot.jpa.repository.UserRepository;
import shanshan.spring.boot.jpa.service.UserService;

/**
 * 用户接口实现
 * @author zss
 * @date 2017年4月20日
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private final UserRepository userRepository;
	
	@Autowired
	private SampleRedisUtil redisUtil;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public UserModel getById(String id) {
		String key = String.format(RedisKeyConstant.USER_INFO, id);
		if(redisUtil.hasKey(key)){
			return redisUtil.getValuefromCache(key, UserModel.class);
		}else{
			logger.info("query user by id = {}",id);
			UserModel user = UserDTOUtil.getUserModel(userRepository.findOne(id));
			if(user != null){
				redisUtil.setValueInCache(key, user);
			}
			return user;
		}
	}

//	@Override
//	public List<UserModel> getByName(String name) {
//		logger.info("query user by name : {}",name);
//		List<User> entityList =  userRepository.nativeQuery("select * from test_user u where u.NAME like ?1", "%"+name+"%");
//		List<UserModel> modelList = new ArrayList<>();
//		entityList.stream().forEach(user -> {
//										modelList.add(UserDTOUtil.getUserModel(user));
//									});
//		return modelList;
//	}

}
