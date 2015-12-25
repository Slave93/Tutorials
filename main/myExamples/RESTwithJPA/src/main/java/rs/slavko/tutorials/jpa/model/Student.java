package rs.slavko.tutorials.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue
	private Integer stid;
	private String ind;
	private String name;
	@ManyToOne(optional=false)
    @JoinColumn(name="addressid",referencedColumnName="adid")
	private Address address;

	public Student() {

	}

	public Student(Integer id, String index, String name, Address addres) {
		super();
		this.stid = id;
		this.ind = index;
		this.name = name;	
		this.address = addres;
	}

	public Integer getId() {
		return stid;
	}

	public void setId(Integer id) {
		this.stid = id;
	}

	public String getIndex() {
		return ind;
	}

	public void setIndex(String index) {
		this.ind = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddres() {
		return address;
	}

	public void setAddres(Address addres) {
		this.address = addres;
	}

}
