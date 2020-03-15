package com.surveythis.rest.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.surveythis.rest.backend.models.SurveyModel;

public interface SurveyRepo extends JpaRepository<SurveyModel, Long>{
	
	@Query("SELECT COUNT(*) FROM SurveyModel S WHERE S.topic.topicID = ?1")
	public int getNoOfSubmissions(long id);
	
	@Query("SELECT COUNT(*) FROM SurveyModel S WHERE S.topic.topicID = ?1 AND score > 8")
	public int getNoOfPromoters(long id);
	
	@Query("SELECT COUNT(*) FROM SurveyModel S WHERE S.topic.topicID = ?1 AND score < 7")
	public int getNoOfDetractors(long id);
	
	
}
