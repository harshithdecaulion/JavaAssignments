package valtechspring_exer.orm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bg")
public class Blog extends Book{

	private String url;
	private int timesvisited;
	
	public Blog(){}

	public Blog(String url, int timesvisited) {
		this.url = url;
		this.timesvisited = timesvisited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTimesvisited() {
		return timesvisited;
	}

	public void setTimesvisited(int timesvisited) {
		this.timesvisited = timesvisited;
	}

	@Override
	public String toString() {
		return "Blog [url=" + url + ", timesvisited=" + timesvisited + ", getId()=" + getId() + ", getName()="
				+ getName() + ", toString()=" + super.toString() + "]";
	}

	
	
}
