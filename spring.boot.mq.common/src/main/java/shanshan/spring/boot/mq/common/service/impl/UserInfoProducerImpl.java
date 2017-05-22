package shanshan.spring.boot.mq.common.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import shanshan.spring.boot.mq.common.base.producer.AbstractMessageProducer;
import shanshan.spring.boot.mq.common.constant.ExchangeConstant;
import shanshan.spring.boot.mq.common.data.UserInfo;
import shanshan.spring.boot.mq.common.service.IProducer;

@Service("userInfoProducer")
public class UserInfoProducerImpl extends AbstractMessageProducer implements
		IProducer<UserInfo> {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void sendMessage(UserInfo userInfo) {
		logger.info("发送mq消息 to {} , meaasge={}", ExchangeConstant.USER_EXCHANGE_KEY, userInfo);
		this.send(ExchangeConstant.USER_EXCHANGE_KEY, ExchangeConstant.USER_ROUTING_KEY, userInfo);
	}

}
