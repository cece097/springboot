package shanshan.spring.boot.jpa.repository.expand;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * SpringDataJPA扩展
 * @author zss
 * @date 2017年5月5日
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface ExpandRepository<T, ID extends Serializable> 
	extends JpaRepository<T, ID> {
	
	/**
	 * 执行nativeSql查询
	 * @param nativeSql
	 * @param params 占位符参数(例如?1)绑定的参数值
	 * @return
	 */
	List<T> nativeQuery(String nativeSql, Object... params);
}
