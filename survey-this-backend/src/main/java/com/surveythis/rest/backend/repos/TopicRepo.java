package com.surveythis.rest.backend.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.surveythis.rest.backend.models.TopicModel;

public interface TopicRepo extends JpaRepository<TopicModel, Long> {
	
	@Transactional
	@Modifying
	@Query("UPDATE TopicModel SET npmScore = ?2 WHERE topicID = ?1")
	public void updateNPM(long id, double newNpm);
}

