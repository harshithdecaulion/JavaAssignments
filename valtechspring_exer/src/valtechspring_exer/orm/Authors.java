package valtechspring_exer.orm;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Authors {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	
	private int id;
	private String name;
	private int phNum;
	
	@OneToOne(targetEntity=Address.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy="authors")
	@JoinColumn(name="authors",referencedColumnName="id")
	private Address address;
	
	
	@ManyToMany(targetEntity=Book.class , cascade={CascadeType.MERGE,CascadeType.PERSIST})
   @JoinTable(name="book_author",joinColumns=@JoinColumn(name="book_id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="author_id",referencedColumnName="id"))

	private Set<Book> books;
	
	
	
	public Authors (){}

	public Authors(int id, String name, int phNum) {
		this.id = id;
		this.name = name;
		this.phNum = phNum;
	}
	
	public Authors(String name, int phNum) {
		this.name = name;
		this.phNum = phNum;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhNum() {
		return phNum;
	}

	public void setPhNum(int phNum) {
		this.phNum = phNum;
	}

	@Override
	public String toString() {
		return "Authors [id=" + id + ", name=" + name + ", phNum=" + phNum + ", address=" + address + ", books=" + books
				+ "]";
	}

	

	
	
	
}
