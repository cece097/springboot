package shanshan.spring.boot.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shanshan.spring.boot.common.model.UserModel;
import shanshan.spring.boot.jpa.service.UserService;
import shanshan.spring.boot.mq.common.base.consumer.AbstractMessageConsumer;
import shanshan.spring.boot.mq.common.data.UserInfo;
import shanshan.spring.boot.mq.constant.QueuesConstant;

@Component
@RabbitListener(queues = QueuesConstant.USER_ADD_QUEUE)
public class UserInfoConsumer extends AbstractMessageConsumer<UserInfo> {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@Override
	public void consume(UserInfo message) throws Exception {
		logger.info("user id = {}", message.getUId());
		UserModel user = userService.getById(message.getUId());
		logger.info("user = {}", user.toString());
	}

}
