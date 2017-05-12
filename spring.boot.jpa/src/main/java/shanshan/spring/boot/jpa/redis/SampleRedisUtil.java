package shanshan.spring.boot.jpa.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import shanshan.spring.boot.common.utils.json.JsonUtil;

@Component
public class SampleRedisUtil {
	
	@Autowired
	private StringRedisTemplate template;
	
	private ValueOperations<String, String> valueOps;
	private ListOperations<String, String> listOps;
	private SetOperations<String, String> setOps;
	private ZSetOperations<String, String> zSetOps;
//	private GeoOperations<String, String> geoOps;  //将地理位置信息储存起来， 并对这些信息进行操作
//	private HyperLogLogOperations<String, String> hllOps; //用来做基数统计的算法(量大)
	private HashOperations<String, String, String> hashOps;
	
	@PostConstruct
	public void setUp() {
		valueOps = template.opsForValue();
		listOps = template.opsForList();
		setOps = template.opsForSet();
		zSetOps = template.opsForZSet();
//		geoOps = template.opsForGeo();
//		hllOps = template.opsForHyperLogLog();
		hashOps = template.opsForHash();
	}
	
	//缓存有效期，单位秒
	private static Map<String, Integer> expireMap = new HashMap<String, Integer>();
	static {
		expireMap.put("User", 3600); //缓存一小时
		expireMap.put("default", 600);
	}
	
	/**
	 * 缓存是否存在
	 * @param key
	 * @return
	 */
	public boolean hasKey(String key) {
		return template.hasKey(key);
	};
	
	public boolean hasHashKey(String key,String hashKey) {
		return hashOps.hasKey(key, hashKey);
	};
	
	/**
	 * 缓存单条记录
	 * @param <T>
	 * @param id
	 * @param o
	 */
	public void setValueInCache(String key,Object obj){
		
		Integer time = expireMap.containsKey(obj.getClass().getSimpleName()) 
							? expireMap.get(obj.getClass().getSimpleName())
							: expireMap.get("default");
		
	    setValueInCache(key, obj, time, TimeUnit.SECONDS);
	}
	
	public void setValueInCache(String key, Object obj, Integer time, TimeUnit unit){
		if(time == null){
			valueOps.set(key, JsonUtil.toJson(obj));
		}else{
			valueOps.set(key, JsonUtil.toJson(obj), time, unit == null ? TimeUnit.SECONDS : unit);
		}
	}
	
	/**
	 * 按照key从redis缓存中取单个对象数据
	 * @param key 
	 * @param clazz
	 * @return
	 */
	public <T> T getValuefromCache(String key,Class<T> clazz) {
		String jsonStr = valueOps.get(key);
		return jsonStr == null ? null : JsonUtil.toObject(jsonStr,clazz);
	}
}
