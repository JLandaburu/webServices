package gA.gAAcademy.JuanManuel.webServices.webServices.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gA.gAAcademy.JuanManuel.webServices.webServices.entity.Topic;
import gA.gAAcademy.JuanManuel.webServices.webServices.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	TopicService topicService;

	@PostMapping("/topic")
	public ResponseEntity<?> createTopic(@RequestBody Topic inputTopic) {
		Topic t = topicService.createTopic(inputTopic);
		return new ResponseEntity<Topic>(t, HttpStatus.OK);
	}
	
	@GetMapping("/topic")
	public ResponseEntity<?> getAllTopics(){
		List<Topic> topicList = topicService.getAllTopics();
		return new ResponseEntity<List<Topic>>(topicList, HttpStatus.OK);
	}
	
	@GetMapping("/topic/{id}")
	public ResponseEntity<?> getTopicById(@PathVariable int id){
		Topic t = topicService.getTopicById(id);
		return new ResponseEntity<Topic>(t, HttpStatus.OK);
	}
	
	@GetMapping("/topic/author/{author}")
	public List<Topic> getTopicsByAuthor(@PathVariable int author){
		List<Topic> topicList = topicService.getTopicsByAuthor(author);
		return topicList;
	}
	
	@GetMapping("/topic/datePost/{datePost}")
	public List<Topic> getTopicsByDatePost(@PathVariable Date datePost){
		List<Topic> topicList = topicService.getTopicsByDatePost(datePost);
		return topicList;
	}
	
	@PutMapping("/topic/{id}")
	public Topic updateTopic(@PathVariable int id, @RequestBody Topic updateTopic) {
		Topic t = topicService.updateTopic(id, updateTopic);
		return t;
	}
	
	@DeleteMapping("/topic/{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable int id) {
		topicService.deleteTopicFis(id);
		String s = "El topic: " + id + " fue borrado exitosamente.";
		return new ResponseEntity<String>(s, HttpStatus.OK); // usamos el constructor que recibe el mensaje y el estado
	}
	
	@DeleteMapping("/topic/logic/{id}")
	public ResponseEntity<?> deleteLogicTopic(@PathVariable int id){
		int wasDeleted = topicService.deleteLogicTopic(id);
		if(wasDeleted > 0) {
			String message = "El topic " + wasDeleted + " fue borrado exitosamente.";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No se pudo borrar.", HttpStatus.NOT_FOUND);
		}
	}
}
