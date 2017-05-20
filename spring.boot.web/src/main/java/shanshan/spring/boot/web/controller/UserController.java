package shanshan.spring.boot.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import shanshan.spring.boot.common.model.UserModel;
import shanshan.spring.boot.jpa.service.UserService;
import shanshan.spring.boot.mongo.service.ActivityService;
import shanshan.spring.boot.mq.common.data.UserInfo;
import shanshan.spring.boot.mq.common.service.IProducer;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ActivityService activityService;
	
	@Resource(name="userInfoProducer")
	private IProducer<UserInfo> userInfoProducer;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * 获取用户个人信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public UserModel getUserById(@PathVariable String id){
		logger.info("query user by id {}", id);
		UserModel user = userService.getById(id);
		activityService.saveLog("tourist", "查询用户信息："+user.toString());
		return user;
	}
	
	/**
	 * 通过姓名查询用户列表
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/name/{name}", method = RequestMethod.GET)
	@ResponseBody
	public List<UserModel> getUserByName(@PathVariable String name){
		logger.info("query user by name : {}", name);
		return userService.getByName(name);
	}
	
	/**
	 * 简单的新增用户
	 * @param mobile
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/add/{mobile}/{name}", method = RequestMethod.GET)
	@ResponseBody
	public UserModel addUser(@PathVariable String mobile, @PathVariable String name){
		logger.info("add user, {}, {} ", mobile, name);
		UserModel user = userService.addNewUser(mobile, name);
		if(user != null){
			activityService.saveLog("tourist", "新增用户："+user.toString());
			//发送mq
			userInfoProducer.sendMessage(new UserInfo(user.getId()));
		}
		return user;
	}
}
