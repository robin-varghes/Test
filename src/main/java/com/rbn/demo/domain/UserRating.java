package com.rbn.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_rating")
public class UserRating implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="user_name")
	private String userName;
	@Column(name="date_of_stay")
	private String dateOfStay;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String desc;
	@Column(name="rating")
	private double rating;

	public UserRating() {
		super();
	}

	public UserRating(Long id, String userName, String dateOfStay, String title, String desc, double rating) {
		super();
		this.id = id;
		this.userName = userName;
		this.dateOfStay = dateOfStay;
		this.title = title;
		this.desc = desc;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDateOfStay() {
		return dateOfStay;
	}

	public void setDateOfStay(String dateOfStay) {
		this.dateOfStay = dateOfStay;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
