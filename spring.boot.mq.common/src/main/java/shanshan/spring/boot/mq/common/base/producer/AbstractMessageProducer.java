package shanshan.spring.boot.mq.common.base.producer;

import org.apache.thrift.TBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import shanshan.spring.boot.mq.common.utils.ThriftUtils;


/**
 * 消息生产者的抽象实现, 提供普通参数对象与Thrift对象之间的转换, 使用户代码对Thrift透明.
 * 
 * @author Wh
 * @lastModified 2015-11-18 18:59:13
 */
public abstract class AbstractMessageProducer implements MessageProducer {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected AmqpTemplate amqpTemplate;

	@Override
	public final void send(String exchange, String routingKey, TBase<?, ?> tbase) {
		amqpTemplate.convertAndSend(exchange, routingKey, ThriftUtils.serialize(tbase));
	}
	
}