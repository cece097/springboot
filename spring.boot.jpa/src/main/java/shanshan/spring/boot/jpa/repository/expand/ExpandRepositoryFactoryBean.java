package shanshan.spring.boot.jpa.repository.expand;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class ExpandRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable> extends
		JpaRepositoryFactoryBean<T, S, ID> {

	public ExpandRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}
	
	@Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
        return new ExpandRepositoryFactory(em);
    }

	/**
	 * 内部类，该类不用在外部访问
	 * @author zss
	 * @date 2017年5月5日
	 */
	private static class ExpandRepositoryFactory extends JpaRepositoryFactory {

		private final EntityManager em;
		
		public ExpandRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
			this.em = entityManager;
		}
		
		@Override
		protected Object getTargetRepository(RepositoryInformation information) {
			return (CustomRepository<?, ?>) getTargetRepository(information, em);
		}
		
		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return CustomRepository.class;
		}
	}
	
}
