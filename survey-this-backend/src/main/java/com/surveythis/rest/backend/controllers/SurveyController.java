package com.surveythis.rest.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveythis.rest.backend.models.SurveyModel;
import com.surveythis.rest.backend.repos.SurveyRepo;
import com.surveythis.rest.backend.repos.TopicRepo;
@CrossOrigin
@RestController
@RequestMapping("/surveys")

public class SurveyController {
	@Autowired
	private SurveyRepo surveyRepo;
	@Autowired
	private TopicRepo topicRepo;
	@CrossOrigin
	@GetMapping("/all")
	public List<SurveyModel> getAllSurveys(){
		return surveyRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public SurveyModel getAllSurveysByID(@PathVariable long id){
		return surveyRepo.findById(id).get();
	}
	
	@CrossOrigin
	@PostMapping("")
	public void addSurvey(@RequestBody SurveyModel survey) {
		surveyRepo.save(survey);   
		int total = surveyRepo.getNoOfSubmissions(survey.getTopic().getTopicID());
		int promoters = surveyRepo.getNoOfPromoters(survey.getTopic().getTopicID());
		int detractors = surveyRepo.getNoOfDetractors(survey.getTopic().getTopicID());
		
		double percentOfProm = ((promoters * 100) / (double)total);
		double percentOfDetr = ((detractors * 100) / (double)total);
		double newNpm = percentOfProm - percentOfDetr;
		
		topicRepo.updateNPM(survey.getTopic().getTopicID(), newNpm);
	}
	
	@PutMapping("/{id}")
	public void addTopic(@RequestBody SurveyModel survey, @PathVariable long id) {
		survey.setSubmitID(id);
		surveyRepo.save(survey);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTopic( @PathVariable long id) {
	surveyRepo.deleteById(id);
	
	}

}
