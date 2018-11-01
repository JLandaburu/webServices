package gA.gAAcademy.JuanManuel.webServices.webServices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gA.gAAcademy.JuanManuel.webServices.webServices.entity.Reply;
import gA.gAAcademy.JuanManuel.webServices.webServices.entity.Topic;
import gA.gAAcademy.JuanManuel.webServices.webServices.repository.ReplyRepository;
import gA.gAAcademy.JuanManuel.webServices.webServices.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	ReplyRepository replyRepository;
	
	public Topic createTopic(Topic inputTopic) {
		Topic t = topicRepository.save(inputTopic); // save guarda el topic y lo devuelve el Topic como esta guardado en la base de datos
		return t;
	}
	
	public Reply createReply(Reply inputReply) {
		inputReply.setDateReply(new Date());
		Reply r = replyRepository.save(inputReply); // save guarda el topic y lo devuelve el Topic como esta guardado en la base de datos
		return r;
	}
	
	public List<Topic> getAllTopics(){
		List<Topic> topicList = new ArrayList<>();
		List<Topic> allTopics = topicRepository.findAll();
		for (Topic t : allTopics) {
			if(!t.isDeleted())
				topicList.add(t);
		}
		return topicList;
	}
	
	public List<Reply> getAllReplies(int id){
		return topicRepository.findById(id).get().getReplies();
	}
	
	public List<Reply> getReplys(int id) throws NoSuchElementException{
		return replyRepository.findByTopic(topicRepository.findById(id).get()).get();
	}	
	
	public Topic getTopicById(int id) {
		Topic t = topicRepository.findById(id).get(); //se llama findById porque el atributo se llama id (depende del nombre del atributo)
		return t;
	}
	
	public List<Topic> getTopicsByAuthor(int author){
		List<Topic> topicList = topicRepository.findByAuthor(author).get();
		return topicList;
	}
	
	public List<Topic> getTopicsByDatePost(Date datePost){
		List<Topic> topicList = topicRepository.findByDatePost(datePost).get();
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
	
	public Reply updateReplyById(int id, Reply reply) throws NoSuchElementException{
		Reply toUpdate = replyRepository.findById(id).get();
		if(reply.getDescription() != null) {
			toUpdate.setDescription(reply.getDescription());
		}
		replyRepository.save(toUpdate);
		return toUpdate;
	}
	public void deleteTopicFis(int id) {
		topicRepository.deleteById(id);
	}
	
	public int deleteLogicTopic(int id) {
		int toReturn = 0; // si el topic ya esta borrado, se retorna 0
		Topic t = topicRepository.findById(id).get();
		if(!t.isDeleted()) {
			t.delete();
			toReturn = t.getId(); // si se puede borrar el topic, se retorna el id del mismo
			topicRepository.save(t);
		}
		return toReturn;
	}
	
	public void deleteAllReplies(int id) {
		Topic t = topicRepository.findById(id).get();
		t.deleteReplies();
		topicRepository.save(t);
	}
	
}
