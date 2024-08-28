package com.example.demo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName = "";
	
	private String firstName;
	
	@NotNull(message="is required")
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=10, message="must be less than or equal to ten")
	private Integer passNumber;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postalCode;
	
	public String getLastName() {
        return lastName;
    }
	
    public String getFirstName() {
        return firstName;
    }
     // Add setters for lastName and firstName if needed
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public Integer getPassNumber() {
		return passNumber;
	}

	public void setPassNumber(Integer passNumber) {
		this.passNumber = passNumber;
	}

	@Override
    public String toString() {
        return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}













