package shanshan.spring.boot.common.utils.json;

import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonUtil {
	
    private static ObjectMapper objectMapper = new ObjectMapper();
    
    /**
     * json转换的一些设置
     */
    @PostConstruct
    public static void init(){
    	objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
    }
    
    public static String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
    
    public static <T> T toObject(String json, Class<T> clazz) {
		if (!StringUtils.hasText(json)) {
			return null;
		}
		
		try {
			return objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    
//	private static JsonGenerator jsonGenerator = null;
//    @PostConstruct
//    public static void init() {
//    	System.out.println("init json ……");
//	    try {
//	        jsonGenerator = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);//直接打印出
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//    }
//    public static void toJson2(Object obj) {
//		try {
//			jsonGenerator.writeObject(obj);
//		} catch (Exception e) {
//		}
//	}    
    
}
