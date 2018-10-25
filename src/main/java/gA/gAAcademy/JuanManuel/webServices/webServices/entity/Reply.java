package gA.gAAcademy.JuanManuel.webServices.webServices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reply {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "topicId")
	private int topicId;
	
	@Column(name = "dateReply")
	private Date dateReply;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "author")
	private int author;
	
	public Reply() {
	}
	public Reply(int topicId, Date dateReply, String description, int author) {
		super();
		this.topicId = topicId;
		this.dateReply = dateReply;
		this.description = description;
		this.author = author;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
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
	
}
