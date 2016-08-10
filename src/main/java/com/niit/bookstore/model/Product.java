package com.niit.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "product")
@Component
public class Product {
	@Id
	private String p_id;
	private String catid;
	private String supid;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="catid",nullable=false,updatable=false,
	 * insertable=false) private Category category;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="supid",nullable=false,updatable=false,
	 * insertable=false) private Supplier supplier;
	 */

	private String p_name;
	private String p_img;
	private String p_desc;
	private int p_quantity;
	private double p_price;
	private String p_author;

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getSupid() {
		return supid;
	}

	public void setSupid(String supid) {
		this.supid = supid;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_desc() {
		return p_desc;
	}

	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}

	public int getP_quantity() {
		return p_quantity;
	}

	public void setP_quantity(int p_quantity) {
		this.p_quantity = p_quantity;
	}

	public double getP_price() {
		return p_price;
	}

	public void setP_price(double p_price) {
		this.p_price = p_price;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public String getP_author() {
		return p_author;
	}

	public void setP_author(String p_author) {
		this.p_author = p_author;
	}

}
