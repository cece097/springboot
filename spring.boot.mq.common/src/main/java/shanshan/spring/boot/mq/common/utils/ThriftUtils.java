package shanshan.spring.boot.mq.common.utils;

import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;

/**
 * Thrift工具类
 * @author Wh
 */
public abstract class ThriftUtils {
	
	/**
	 * 序列化
	 * 
	 * @param tbase
	 * @return
	 */
	public static byte[] serialize(TBase<?, ?> tbase) {
		try {
			return new TSerializer().serialize(tbase);
		} catch (TException e) {
			e.printStackTrace();
		}
		return new byte[0];
	}
	
	/**
	 * 反序列化
	 * @param <T>
	 * 
	 * @param tbase
	 * @param msg
	 */
	public static void deserialize(TBase<?, ?> tbase, byte[] msg) {
		try {
			new TDeserializer().deserialize(tbase, msg);
		} catch (TException e) {
			e.printStackTrace();
		}
	}
}