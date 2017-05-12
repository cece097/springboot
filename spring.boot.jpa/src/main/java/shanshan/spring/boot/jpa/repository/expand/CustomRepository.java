package shanshan.spring.boot.jpa.repository.expand;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean  //必须用此注解，无需实例化
@Transactional(readOnly = true)
public class CustomRepository<T, ID extends Serializable> 
		extends SimpleJpaRepository<T, ID>
		implements ExpandRepository<T, ID> {

	private final EntityManager em;
	
	public CustomRepository(JpaEntityInformation<T, ?> entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}
	
	public CustomRepository(Class<T> domainClass, EntityManager entityManager) {
		this(JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager), entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> nativeQuery(String nativeSql,Object... params) {
		return getNativeQuery(nativeSql, params).getResultList();
	}
	
	private <T> Query getNativeQuery(String sql, Object... params) {
		Query q = createNativeQuery(getDomainClass(), sql, params);
		return q;
	}
	
	private <T> Query createNativeQuery(Class<T> resultClass, String sql, Object... params) {
		Query q = em.createNativeQuery(sql, resultClass);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i + 1, params[i]); // 与Hiberante不同,jpa query从位置1开始
		}
		return q;
	}
	
}
