package shanshan.spring.boot.jpa.entity.base;

import java.io.Serializable;

import shanshan.spring.boot.common.utils.json.JsonUtil;

/**
 * 瀹炰綋鍏叡灞炴�ф垨鏂规硶
 * @author zss
 * @date 2017骞�4鏈�20鏃�
 */
public abstract class EntityBase implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public String toString() {
        return JsonUtil.toJson(this);
    }

}
