package shanshan.spring.boot.jpa.common;

import shanshan.spring.boot.common.model.UserModel;
import shanshan.spring.boot.jpa.entity.user.User;


/**
 * 瀵硅薄杞崲宸ュ叿绫�
 * @author zss
 * @date 2017骞�5鏈�11鏃�
 */
public class UserDTOUtil {
	
	
	public static UserModel getUserModel(User user){
		if(user == null){
			return null;
		}else{
			return new UserModel(user.getId(), 
								 user.getName(), 
								 user.getMobile(),
								 user.getTimeCreate());
		}
	}
}
