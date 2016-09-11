package com.niit.bookstore.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "product")
@Component
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String p_id;
	private String catid;
	private String supid;
	private String p_name;
	private String p_desc;
	private int p_quantity;
	private double p_price;
	@Column(name="out_of_stock")
	private boolean out_of_stock;
	private String p_author;
	@Transient
	private MultipartFile productimg;

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

	public String getP_author() {
		return p_author;
	}

	public void setP_author(String p_author) {
		this.p_author = p_author;
	}
	
	public Product(){
		this.p_id='P'+ UUID.randomUUID().toString().substring(24).toUpperCase();
	}

	public boolean isOut_of_stock() {
		return out_of_stock;
	}

	public void setOut_of_stock(boolean out_of_stock) {
		this.out_of_stock = out_of_stock;
	}

	public MultipartFile getProductimg() {
		return productimg;
	}

	public void setProductimg(MultipartFile productimg) {
		this.productimg = productimg;
	}

}
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
