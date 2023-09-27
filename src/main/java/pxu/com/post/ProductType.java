package pxu.com.post;

import javax.persistence.Column;

public class ProductType {
	
	
	private int id_producttype;

	private String type_name;

	public ProductType(int id_producttype, String type_name) {
		super();
		this.id_producttype = id_producttype;
		this.type_name = type_name;
	}

	public ProductType() {
		super();
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

}
