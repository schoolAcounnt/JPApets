package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="pets")
public class petList {
	@Id
	@GeneratedValue
	private int id;
	private String type;
	private String name;
	private String owner;
	public petList() {
		
	}
	
	public petList(String type, String name, String owner) {
		super();
		this.type = type;
		this.name = name;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String returnItemDetails() {
		return this.name + ": " + this.type+ ": " + this.owner;
	}
	
	
}
