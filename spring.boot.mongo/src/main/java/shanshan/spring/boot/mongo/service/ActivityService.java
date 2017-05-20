package shanshan.spring.boot.mongo.service;

public interface ActivityService {
	
	/**
	 * 保存日志
	 * @param operator
	 * @param message
	 */
	public void saveLog(String operator, String message);
}
