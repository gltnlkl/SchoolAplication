package common;

import java.io.Serializable;

public class Name implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String middleName;
	
	
	public Name(String firstName, String middleName,String lastName ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}

	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = "-";
	}
	

	@Override
	public String toString() {
		return "[" + firstName  + ", Middle Name: " + middleName +  ", Last Name: " + lastName +"]";
	}



	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getMiddleName() {
		return middleName;
	}
	
	
	
	
}
