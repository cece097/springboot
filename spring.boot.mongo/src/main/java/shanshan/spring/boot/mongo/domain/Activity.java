package shanshan.spring.boot.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 重要操作行为记录
 * @author zss
 * @date 2017年5月20日
 */
@Document(collection = "TB_ACTIVITY")
public class Activity {
	
	@Id
	private String id;
	
	private String operator;
	
	private String message;

	public Activity(){
	}
	
	public Activity(String id, String operator, String message){
		this.id = id;
		this.operator = operator;
		this.message = message;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
