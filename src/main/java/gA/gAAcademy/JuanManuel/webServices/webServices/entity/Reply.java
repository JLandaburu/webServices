package gA.gAAcademy.JuanManuel.webServices.webServices.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "dateReply")
	private Date dateReply;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "author")
	private int author;
	
	@ManyToOne(cascade = CascadeType.ALL) //cascade all se define de los dos lados
	@JoinColumn(name = "topic") //foreign key, en la base de datos se termina guardando solo el topicId //se le coloca el mismo nombre que el mappedBy en Topic
	private Topic topic;
	
	public Reply() {
	}
	public Reply(Date dateReply, String description, int author, Topic topic) {
		super();
		this.dateReply = dateReply;
		this.description = description;
		this.author = author;
		this.topic = topic;
	}
	public Date getDateReply() {
		return dateReply;
	}
	public void setDateReply(Date dateReply) {
		this.dateReply = dateReply;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
