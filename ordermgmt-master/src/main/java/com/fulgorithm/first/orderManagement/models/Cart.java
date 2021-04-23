package com.fulgorithm.first.orderManagement.models;

import java.sql.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table

public class Cart {

	@Id
	@GeneratedValue
	
	
	
//@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "plan_id")
//	private Products products;
	
	private int cart_id;
	
	private int plan_id;
	
	private int qty;
	
	private double total_price;
	
	private Date added_date;
	
	
	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public Date getAdded_date() {
		return added_date;
	}

	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}

	

	public Cart(int cart_id, int plan_id, int qty, double total_price, Date added_date) {
		super();
		this.cart_id = cart_id;
		this.plan_id = plan_id;
		this.qty = qty;
		this.total_price = total_price;
		this.added_date = added_date;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
