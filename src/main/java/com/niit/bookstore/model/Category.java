package com.niit.bookstore.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="category")
@Component
public class Category {
	
	@Id
	private String catid;

	private String catname;

	private String catdescription;
	
	@Transient
	private MultipartFile catimg;

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

	public MultipartFile getCatimg() {
		return catimg;
	}

	public void setCatimg(MultipartFile catimg) {
		this.catimg = catimg;
	}
	
	public Category (){
		this.catid = 'C' +UUID.randomUUID().toString().substring(24).toUpperCase();
	}
}
