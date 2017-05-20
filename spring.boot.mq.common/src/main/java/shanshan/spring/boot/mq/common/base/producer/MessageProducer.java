package shanshan.spring.boot.mq.common.base.producer;

import org.apache.thrift.TBase;

/**
 * 规定消息发送时必须传入交换区名, 路由关键字, 数据对象为Thrfit对象
 * 
 * @author Wh
 * @lastModified 2015-11-18 18:58:10
 */
public interface MessageProducer {

	void send(String exchange, String routingKey, TBase<?, ?> tbase);
	
}