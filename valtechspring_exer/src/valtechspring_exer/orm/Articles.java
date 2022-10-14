package valtechspring_exer.orm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("arc")
public class Articles extends Book{

	private String url;
	
	public Articles (){}

	public Articles(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Articles [url=" + url + ", getId()=" + getId() + ", getName()=" + getName() + ", getWhenPublished()="
				+ getWhenPublished() + "]";
	}


	
}
