package shanshan.spring.boot.mq.common.base.consumer;

import org.apache.thrift.TBase;

/**
 * 规定了消费者消费的数据必须是Thrift的TBase对象<br/>
 * 使用Thrift的TBase对象可以使传输数据的二进制形式对各种语言都有一致的兼容性
 * 
 * @author Wh
 * @lastModified 2015-11-19 11:32:19
 * @param <T> TBase的实现类
 */
public interface MessageConsumer<T extends TBase<?, ?>> {
	
	void consume(T message) throws Exception;
	
}