package shanshan.spring.boot.common.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectUtil<T> {
	
	Logger logger = LoggerFactory.getLogger(ReflectUtil.class);
	
	private List<T> reflectListSet(Class<T> resultClass, List<Object[]> entityList){
		List<T> ret = new ArrayList<T>();
		for(Object result : entityList) {
			ret.add(reflectSet(resultClass, result));
		}
		return ret;
	}
	
	/**
	 * 将查询object 转换为实体类
	 * @param resultClass
	 * @param entity
	 * @return
	 */
	private T reflectSet(Class<T> resultClass, Object entity){
		if(entity instanceof Object[]) {
			Field[] fileds = resultClass.getDeclaredFields();
			try {
				T t = resultClass.newInstance();
				Object[] resultArray = (Object[])entity;
				for (int i = 0, j = 0; i < resultArray.length; ) {
					if(Modifier.isStatic(fileds[j].getModifiers()) || Modifier.isFinal(fileds[j].getModifiers())) {
						j++;
						continue;
					}
					fileds[j].setAccessible(true);
					if(fileds[j].getType().isEnum()){
						fileds[j].set(t, Enum.valueOf((Class) fileds[j].getType(), String.valueOf(resultArray[i])));
					}else if(fileds[j].getType().getName().equals("int")){
						fileds[j].set(t, resultArray[i] instanceof Integer ? ((Integer)resultArray[i]).intValue() : ((BigInteger)resultArray[i]).intValue());
					}else if(fileds[j].getType().getName().equals("boolean")){
						fileds[j].set(t, resultArray[i] instanceof Integer ? ((Integer)resultArray[i]).intValue()==1 : ((BigInteger)resultArray[i]).intValue()==1);
					}else{
						fileds[j].set(t, resultArray[i]);
					}
					i++;
					j++;
                }
				return t;
			} catch (ReflectiveOperationException e) {
				logger.error("Class with NativeQueryResultEntity annotation must supply no arg construct and ", e);
			}
		} else {
			logger.error("Class with NativeQueryResultEntity annotation must return object array");
		}
		return null;
	}
}
