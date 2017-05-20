package shanshan.spring.boot.web.controller;

import java.util.List;

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


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ActivityService activityService;
	
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
}
