package valtechspring_exer.orm;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String address;
	private long pohneNum;
	@OneToMany(targetEntity=Book.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy="publisher")
	private Set<Book> books;
	
	

public Publisher(){}

public Publisher(String name, String address, long pohneNum) {
	this.name = name;
	this.address = address;
	this.pohneNum = pohneNum;
}
public Publisher(int id, String name, String address, long pohneNum) {
	this.id = id;
	this.name = name;
	this.address = address;
	this.pohneNum = pohneNum;
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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public long getPohneNum() {
	return pohneNum;
}

public void setPohneNum(long pohneNum) {
	this.pohneNum = pohneNum;
}

@Override
public String toString() {
	return "Publisher [id=" + id + ", name=" + name + ", address=" + address + ", pohneNum=" + pohneNum + ", books="
			+ books + "]";
}




}