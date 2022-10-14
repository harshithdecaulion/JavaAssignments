package valtechspring_exer.orm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bbd")
public class BookBind extends Book{

	private int price;
	private int edition;
	private int isbn;
	
	public BookBind (){}

	public BookBind(int price, int edition, int isbn) {
		this.price = price;
		this.edition = edition;
		this.isbn = isbn;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "BookBind [price=" + price + ", edition=" + edition + ", isbn=" + isbn + ", getId()=" + getId()
				+ ", getName()=" + getName() + "]";
	}
	
	
}
