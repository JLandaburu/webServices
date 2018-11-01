package gA.gAAcademy.JuanManuel.webServices.webServices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gA.gAAcademy.JuanManuel.webServices.webServices.entity.Reply;
import gA.gAAcademy.JuanManuel.webServices.webServices.entity.Topic;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
	
	Optional<List<Reply>> findByTopic(Topic topic);
	
}
