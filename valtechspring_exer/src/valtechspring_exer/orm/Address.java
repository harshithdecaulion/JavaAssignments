package valtechspring_exer.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String city;
	private String outlet;
	private String state;
	private int zipcode;

	  @OneToOne(targetEntity=Authors.class)
      @JoinColumn(name="authors_id",referencedColumnName="id")
      private Authors authors;
	
	  public Address (){}
	
	public Address(String city, String outlet, String state, int zipcode) {
		this.city = city;
		this.outlet = outlet;
		this.state = state;
		this.zipcode = zipcode;
	}
	public Address(int id, String city, String outlet, String state, int zipcode) {
		super();
		this.id = id;
		this.city = city;
		this.outlet = outlet;
		this.state = state;
		this.zipcode = zipcode;
	}

	
	public Authors getAuthors() {
		return authors;
	}

	public void setAuthors(Authors authors) {
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOutlet() {
		return outlet;
	}

	public void setOutlet(String outlet) {
		this.outlet = outlet;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", outlet=" + outlet + ", state=" + state + ", zipcode="
				+ zipcode + ", authors=" + authors + "]";
	}

	
	
}
