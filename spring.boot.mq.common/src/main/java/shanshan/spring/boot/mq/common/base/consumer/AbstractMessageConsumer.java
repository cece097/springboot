package shanshan.spring.boot.mq.common.base.consumer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.thrift.TBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import shanshan.spring.boot.mq.common.utils.ThriftUtils;


/**
 * 定义模版方法<code>handleMessage()</code>, 规定所有消费者消费的整个流程, 具体的消息处理交给子类
 * 
 * @author Wh
 * @lastModified 2015-11-19 11:41:50
 * @param <T> TBase
 */
public abstract class AbstractMessageConsumer<T extends TBase<?, ?>> implements MessageConsumer<T> {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractMessageConsumer.class);
	
	public final void handleMessage(byte[] message) {
		try {
			Class<T> tbaseClass = getTBaseClass();
			T tbase = tbaseClass.newInstance();
			ThriftUtils.deserialize(tbase, message);
			consume(tbase);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getTBaseClass() {
		Type type = getClass().getGenericSuperclass();
		Type[] genericTypes = ((ParameterizedType) type).getActualTypeArguments();
		Class<T> genericClass = (Class<T>) genericTypes[0];
		return genericClass;
	}
	
}
