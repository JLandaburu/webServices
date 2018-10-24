package gA.gAAcademy.JuanManuel.webServices.webServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gA.gAAcademy.JuanManuel.webServices.webServices.entity.Topic;
import gA.gAAcademy.JuanManuel.webServices.webServices.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;

	public Topic createTopic(Topic inputTopic) {
		Topic t = topicRepository.save(inputTopic); // save guarda el topic y lo devuelve el Topic como esta guardado en
													// la base de datos
		return t;
	}
	
	public List<Topic> getAllTopics(){
		List<Topic> topicList = topicRepository.findAll();
		return topicList;
	}
	
}
