package shanshan.spring.boot.mongo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shanshan.spring.boot.mongo.domain.Activity;
import shanshan.spring.boot.mongo.repository.ActivityRepository;
import shanshan.spring.boot.mongo.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	private static final Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Override
	public void saveLog(String operator, String message) {
		logger.info("add new log [operator={}][message={}]", operator, message);
		activityRepository.save(new Activity(null, operator, message));
	}

}
