package com.surveythis.rest.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TopicModel {
	@Id
	@GeneratedValue
	private Long topicID;
	private String topicName;
	private String surveyQuestion;
	private double npmScore;
	/**
	 * @return the topicID
	 */
	public Long getTopicID() {
		return topicID;
	}
	/**
	 * @param topicID the topicID to set
	 */
	public void setTopicID(Long topicID) {
		this.topicID = topicID;
	}
	/**
	 * @return the topicName
	*/
	public String getTopicName() {
		return topicName;
	}
	/**
	 * @param topicName the topicName to set
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	/**
	 * @return the npmScore
	 */
	public double getNpmScore() {
		return npmScore;
	}
	/**
	 * @param npmScore the npmScore to set
	 */
	public void setNpmScore(double npmScore) {
		this.npmScore = npmScore;
	}
	public String getSurveyQuestion() {
		return surveyQuestion;
	}
	/**
	 * @param surveyQuestion the surveyQuestion to set
	 */
	public void setSurveyQuestion(String surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

}
