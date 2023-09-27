package pxu.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producttype")
public class Producttype {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producttype")
	private int id_producttype;

	@Column(name = "type_name")
	private String type_name;

	public Producttype(int id_producttype, String type_name) {
		super();
		this.id_producttype = id_producttype;
		this.type_name = type_name;
	}

	public int getId_producttype() {
		return id_producttype;
	}

	public void setId_producttype(int id_producttype) {
		this.id_producttype = id_producttype;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public Producttype() {
		super();
	}

}
