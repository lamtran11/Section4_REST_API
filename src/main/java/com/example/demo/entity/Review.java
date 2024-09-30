package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="review")
public class Review {

    // define the fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // auto-increment the id field using MySQL's auto_increment feature
	@Column(name="id")  // map to the db column named "id"
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	// create constructors
	public Review() {
	}
	
	public Review(String comment) {
        this.comment = comment;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
	
	
	
	// generate getter/setter methods
	
	// generate toString() method
	
}
