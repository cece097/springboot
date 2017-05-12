package shanshan.spring.boot.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shanshan.spring.boot.jpa.entity.user.User;
import shanshan.spring.boot.jpa.repository.expand.ExpandRepository;


public interface UserRepository extends ExpandRepository<User, String> {
	
	@Query("from User u where u.name = :name")
	public User findByName(@Param("name") String name);
}
