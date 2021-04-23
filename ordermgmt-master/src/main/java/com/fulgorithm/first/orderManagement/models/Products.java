package com.fulgorithm.first.orderManagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int plan_id;
	
	private String plan_name;
	
	private double unit_price;
	
	private String currency;
	
	private int billing_freq;
	
	private String description;
	
	private String status;
	
	private String creation_date;
	
	private String updation_date;
	
	private int tenant_id;
	
	private int user_id;
	
	
	private int Category_id;
	
	

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getBilling_freq() {
		return billing_freq;
	}

	public void setBilling_freq(int billing_freq) {
		this.billing_freq = billing_freq;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getUpdation_date() {
		return updation_date;
	}

	public void setUpdation_date(String updation_date) {
		this.updation_date = updation_date;
	}

	public int getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(int tenant_id) {
		this.tenant_id = tenant_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	

	public int getCategory_id() {
		return Category_id;
	}

	public void setCategory_id(int category_id) {
		Category_id = category_id;
	}

	public Products(int plan_id, String plan_name, double unit_price, String currency, int billing_freq,
			String description, String status, String creation_date, String updation_date, int tenant_id,
			int user_id, int Category_id) {
		super();
		this.plan_id = plan_id;
		this.plan_name = plan_name;
		this.unit_price = unit_price;
		this.currency = currency;
		this.billing_freq = billing_freq;
		this.description = description;
		this.status = status;
		this.creation_date = creation_date;
		this.updation_date = updation_date;
		this.tenant_id = tenant_id;
		this.user_id = user_id;
		this.Category_id = Category_id;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
