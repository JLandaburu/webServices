package gA.gAAcademy.JuanManuel.webServices.webServices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gA.gAAcademy.JuanManuel.webServices.webServices.entity.Topic;
import gA.gAAcademy.JuanManuel.webServices.webServices.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;

	public Topic createTopic(Topic inputTopic) {
		Topic t = topicRepository.save(inputTopic); // save guarda el topic y lo devuelve el Topic como esta guardado en la base de datos
		return t;
	}
	
	public List<Topic> getAllTopics(){
		List<Topic> topicList = topicRepository.findAll();
		return topicList;
	}
	
	public Topic getTopicById(int id) {
		Optional<Topic> ot = topicRepository.findById(id); //se llama findById porque el atributo se llama id (depende del nombre del atributo)
		Topic t = ot.get();
		return t;
	}
	
	public List<Topic> getTopicsByAuthor(int author){
		List<Topic> topicList = new ArrayList<>();
		List<Topic> allTopics = this.getAllTopics();
		for (Topic t : allTopics) {
			if(t.getAuthor() == author) {
				topicList.add(t);
			}
		}
		return topicList;
	}
	
	public List<Topic> getTopicsByDatePost(Date datePost){
		List<Topic> topicList = new ArrayList<>();
		List<Topic> allTopics = this.getAllTopics();
		for (Topic t : allTopics) {
			if(t.getDatePost().equals(datePost)) {
				topicList.add(t);
			}
		}
		return topicList;
	}
	
	public Topic updateTopic(int id, Topic updateTopic) { //el updateTopic solo tiene los atributos que se quieren modificar, se debe preguntar qué atributos tienen valor para modificarlos
		Topic toUpdateTopic = topicRepository.findById(id).get();
		if(updateTopic.getAuthor() != 0) { //si está vacio es igual a 0 //tambien se puede modificar el autor
			toUpdateTopic.setAuthor(updateTopic.getAuthor());
		}
		if(updateTopic.getTitle() != null) {
			toUpdateTopic.setTitle(updateTopic.getTitle());
		}
		if(updateTopic.getDescription() != null) {
			toUpdateTopic.setDescription(updateTopic.getDescription());
		} //la fecha no la modificamos, crea la fecha de creacion (para modificarla deberia haber dos atributos, fecha de creacion y fecha de modificacion)
		Topic t = topicRepository.save(toUpdateTopic);
		return t;
	}
}
