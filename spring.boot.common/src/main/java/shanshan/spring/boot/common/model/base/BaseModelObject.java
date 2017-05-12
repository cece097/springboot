package shanshan.spring.boot.common.model.base;

import java.io.Serializable;

import shanshan.spring.boot.common.utils.json.JsonUtil;

/**
 * Model基类
 * @author zss
 * @date 2017年5月11日
 */
public abstract class BaseModelObject implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6794332339314221799L;

	@Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
