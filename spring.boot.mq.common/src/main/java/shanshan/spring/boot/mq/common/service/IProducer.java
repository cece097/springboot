package shanshan.spring.boot.mq.common.service;

import org.apache.thrift.TBase;

public interface IProducer<T extends TBase<?, ?>> {
	
	/**
	 * 发送mq消息
	 * @param tbase
	 */
	public void sendMessage(T tbase);
}
