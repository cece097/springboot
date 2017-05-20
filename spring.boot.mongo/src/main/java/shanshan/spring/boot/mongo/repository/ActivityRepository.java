package shanshan.spring.boot.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import shanshan.spring.boot.mongo.domain.Activity;

public interface ActivityRepository extends MongoRepository<Activity, String> {

}
