package com.example.RestControllerDemo.entity;

public class Student {
	
	private String firstName;
	private String lastName;
	
	//if you wish to make the object of the class without passing any 
   //initial values Employee president = new Employee(); This statement 
//	would throw an errorNo default constructor found; nested exception 
//	is java.lang.NoSuchMethodException:.Thus there are explicit 
//	definitions for the no-arg constructors to support such object 
//	creation, where a user may allocate heap space for a object first, 
//	and then initialise it later using the setter methods or some other 
//	mechanisms.
	public Student() {
		
	}
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
}
