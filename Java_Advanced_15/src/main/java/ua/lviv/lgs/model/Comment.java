package ua.lviv.lgs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String authroName;
	
	@ManyToOne
	private Post post;
	
	public Comment() {}
	
	public Comment(String authroName) {
		this.authroName = authroName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthroName() {
		return authroName;
	}

	public void setAuthroName(String authroName) {
		this.authroName = authroName;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
	
}
