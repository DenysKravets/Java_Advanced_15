package ua.lviv.lgs.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ua.lviv.lgs.model.Comment;
import ua.lviv.lgs.model.Post;

public class Main {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.getTransaction().begin();;
		
		List<Comment> comments = new ArrayList<>();
		
		comments.add(new Comment("oi"));
		comments.add(new Comment("oii"));
		comments.add(new Comment("oiii"));
		
		Post post = new Post();
		post.setTitle("MyPost");
		post.setComments(comments);
		
		for(Comment c: comments) {
			c.setPost(post);
			session.persist(c);
		}
		session.persist(post);
		
		session.getTransaction().commit();
		

	}
}
