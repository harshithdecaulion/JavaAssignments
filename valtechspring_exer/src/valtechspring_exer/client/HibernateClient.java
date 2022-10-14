package valtechspring_exer.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import valtechspring_exer.orm.Address;
import valtechspring_exer.orm.Articles;
import valtechspring_exer.orm.Authors;
import valtechspring_exer.orm.Blog;
import valtechspring_exer.orm.Book;
import valtechspring_exer.orm.BookBind;
import valtechspring_exer.orm.Publisher;

public class HibernateClient {

	public static void main (String [] args){
		SessionFactory sf = new AnnotationConfiguration()
				.configure()
				.addAnnotatedClass(Publisher.class)
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Authors.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(BookBind.class)
				.addAnnotatedClass(Articles.class)
				.addAnnotatedClass(Blog.class)
				.buildSessionFactory();
		
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
		
		Address a =new Address("JP Nagar","Bengaluru","Karnataka",560078);
		
//		Book b = new Book("2 states","2005");
//		Blog bg = new Blog("http://www.chetanbhagat.com/", 2);
//		BookBind bbd = new BookBind(499, 2, 5987654);
//		Publisher publ = new Publisher("Rupa Publications Pvt. Ltd.", "Delhi 6", 25113213);
//		
		ses.save(a);
//		ses.save(b);
//		ses.save(bg);
//		ses.save(bbd);
//		ses.save(publ);
		
		tx.commit();
		ses.close();
		sf.close();
		
		
		
	}
}
