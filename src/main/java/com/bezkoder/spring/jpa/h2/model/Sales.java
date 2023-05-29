package com.bezkoder.spring.jpa.h2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Sales {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String productName;
	    private String customerName;
	    private Integer quantity;
	    private Double price;
	    
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date date;

		public Sales(Long id, String productName, String customerName, Integer quantity, Double price, Date date) {
			super();
			this.id = id;
			this.productName = productName;
			this.customerName = customerName;
			this.quantity = quantity;
			this.price = price;
			this.date = date;
		}

		public Sales() {
			
		}
	    
}
