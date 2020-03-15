package com.surveythis.rest.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class SurveyModel {
	@Id
	@GeneratedValue
	private Long submitID;
	private double score;
	
	private String feedback;
	@ManyToOne
	@JoinColumn
	private TopicModel topic;
	/**
	 * @return the submitID
	 */
	public Long getSubmitID() {
		return submitID;
	}
	/**
	 * @param submitID the submitID to set
	 */
	public void setSubmitID(Long submitID) {
		this.submitID = submitID;
	}
	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}
	/**
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}
	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	/**
	 * @return the topic
	 */
	public TopicModel getTopic() {
		return topic;
	}
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(TopicModel topic) {
		this.topic = topic;
	}
	/**
	 * @return the surveyQuestion
	 */
	

}
