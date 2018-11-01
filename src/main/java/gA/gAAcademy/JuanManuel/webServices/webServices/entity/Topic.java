package gA.gAAcademy.JuanManuel.webServices.webServices.entity;

import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.OneToMany;

@Entity
public class Topic {

	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //se genera de manera automatica
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "datePost")
	private Date datePost;

	@Column(name = "description")
	private String description;

	@Column(name = "author")
	private int author; // author is int, not String
	
	@Column(name = "deleted")
	private boolean deleted;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true) //relacion de uno a muchos //fetch LAZY hace que incorpore en la memoria directamente de la base de datos todos los replies definidos por la foreign key
	private List<Reply> replies = new ArrayList<Reply>();													//en mappedBy debe ir lo mismo que en el name de la JoinColumn de Reply //cascade all: permiso para hacer todas las acciones posibles con los replies //orphan true: un reply puede quedar como huerfano si borran el topic

	public Topic() {
	}

	public Topic(String title, Date datePost, String description, int author, List<Reply> replies) {
		super();
		this.title = title;
		this.datePost = datePost;
		this.description = description;
		this.author = author;
		this.replies = replies;
		this.deleted = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
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

	public boolean isDeleted() {
		return deleted;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void delete() {
		this.deleted = true;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	
	public void deleteReplies() {
		this.replies.clear();
	}
}
