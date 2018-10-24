package gA.gAAcademy.JuanManuel.webServices.webServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gA.gAAcademy.JuanManuel.webServices.webServices.entity.Topic;
import gA.gAAcademy.JuanManuel.webServices.webServices.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	TopicService topicService;

	@PostMapping("/topic")
	public Topic createTopic(@RequestBody Topic inputTopic) {
		Topic t = topicService.createTopic(inputTopic);
		return t;
	}
	
	@GetMapping("/topic")
	public List<Topic> getAllTopics(){
		List<Topic> topicList = topicService.getAllTopics();
		return topicList;
	}
	
	@GetMapping("/topic/{id}")
	public Topic getTopicById(@PathVariable int id){
		Topic t = topicService.getTopicById(id);
		return t;
	}
	
	@GetMapping("/topic/author/{author}")
	public List<Topic> getTopicsByAuthor(@PathVariable int author){
		List<Topic> topicList = topicService.getTopicsByAuthor(author);
		return topicList;
	}
	
}
