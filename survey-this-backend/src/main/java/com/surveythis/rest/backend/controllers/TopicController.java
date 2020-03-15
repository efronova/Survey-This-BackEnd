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
import com.surveythis.rest.backend.models.TopicModel;
import com.surveythis.rest.backend.repos.TopicRepo;

@CrossOrigin
@RestController
@RequestMapping("/topics")
public class TopicController {
	
	@Autowired
	private TopicRepo topicRepo;
	
	@CrossOrigin
	@GetMapping("/all")
	public List<TopicModel> getAllTopics(){
		return topicRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public TopicModel getAllTopicsByID(@PathVariable long id){
		return topicRepo.findById(id).get();
	}
	
	@CrossOrigin
	@PostMapping("")
	public void addTopic(@RequestBody TopicModel topic) {
		topicRepo.save(topic);   
	}
	
	@PutMapping("/{id}")
	public void addTopic(@RequestBody TopicModel topic, @PathVariable long id) {
		topic.setTopicID(id);
		topicRepo.save(topic);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTopic( @PathVariable long id) {
		topicRepo.deleteById(id);
	
	}
}

