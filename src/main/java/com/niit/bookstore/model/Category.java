package com.niit.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="category")
@Component
public class Category {
	
	@Id
	private String catid;

	private String catname;

	private String catdescription;
	
	private String catimg;

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getCatdescription() {
		return catdescription;
	}

	public void setCatdescription(String catdescription) {
		this.catdescription = catdescription;
	}

	public String getCatimg() {
		return catimg;
	}

	public void setCatimg(String catimg) {
		this.catimg = catimg;
	}
}
