package com.arshiya.kitchenstory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","user"})
public class Orders {
	@Id @GeneratedValue
	@Column(name="orderid")
	private long orderid;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	@JsonIgnoreProperties("orders")
	private User user;
	
	@Column(name="address")
	private String address;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
	@JsonIgnoreProperties("orders")
    private List<OrderItem> orderitem;
	
	@Column(name="totalprice",columnDefinition = "DECIMAL(10,2) default 0")
	private float totalprice;
	

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItem> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(List<OrderItem> orderitem) {
		this.orderitem = orderitem;
	}

	
	
	
}
