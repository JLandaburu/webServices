package gA.gAAcademy.JuanManuel.webServices.webServices.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gA.gAAcademy.JuanManuel.webServices.webServices.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
	
	Optional<List<Topic>> findByAuthor(int author);
	Optional<List<Topic>> findByDatePost(Date datePost);
}
