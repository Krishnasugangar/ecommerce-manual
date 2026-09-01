package com.example.ecommercemanual.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime orderDate;
	private BigDecimal price;
	private String status;
	
	 @ManyToOne
	 @JoinColumn(name = "user_id", nullable=false)
	 private User user;
	 
	 
	// --- The Many-to-Many Relationship (Join Table) ---
	    @ManyToMany
	    @JoinTable(
	            name = "order_items",
	            joinColumns = @JoinColumn(name = "order_id"),
	            inverseJoinColumns = @JoinColumn(name = "product_id")
	    )
	    private List<Product> products = new ArrayList<>();

	 public Long getId() {
		 return id;
	 }

	 public LocalDateTime getOrderDate() {
		 return orderDate;
	 }

	 public BigDecimal getPrice() {
		 return price;
	 }

	 public String getStatus() {
		 return status;
	 }

	 public User getUser() {
		 return user;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public void setOrderDate(LocalDateTime orderDate) {
		 this.orderDate = orderDate;
	 }

	 public void setPrice(BigDecimal price) {
		 this.price = price;
	 }

	 public void setStatus(String status) {
		 this.status = status;
	 }

	 public void setUser(User user) {
		 this.user = user;
	 }

	 @Override
	 public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", price=" + price + ", status=" + status + ", user="
				+ user + "]";
	 }

	 public Order() {
		
	 }
	 
	 public List<Product> getProducts() {
	        return products;
	    }

	    public void setProducts(List<Product> products) {
	        this.products = products;
	    }
	 
	
}
