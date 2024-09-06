package com.example.demo.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "このフィルドが必須です。")
	@Size(min = 3, message = "最低長さは３です。")
	@Column(name = "last_name")
	private String lastName;

	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Gmailの形式が正しくない。")
	@NotNull(message = "このフィルドが必須です。")
	@Column(name = "email")
	private String email;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	public Student() {

	}

	public Student(int id, String firstName, String lastName, String email, LocalDateTime createdAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.createdAt = createdAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getFormattedCreatedAt() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd(EEEE)");
		
		return createdAt != null ? createdAt.format(formatter) : "Not Available";
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
