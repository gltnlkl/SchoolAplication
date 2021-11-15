package common;

import java.io.Serializable;
import java.time.LocalDate;

import common.Enum.Gender;
import common.Enum.MarriageStatus;
import common.Enum.Occupation;
import main.RegNo;

public abstract class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Occupation occupation;
	private Name name;
	protected Gender gender;
	private long age;
	protected LocalDate startingDate;
	protected LocalDate leavingDate;
	private PhoneNumber phoneNumber;
	private LocalDate birthday;
	protected MarriageStatus marriageStatus;
	private String id;
	private String regNo;
	

	

		
	

	public Person( String id,Occupation occupation, Name name, Gender gender, long age, LocalDate startingDate,
			LocalDate leavingDate, PhoneNumber phoneNumber, LocalDate birthday, MarriageStatus marriageStatus) {
		
		super();
	
		this.id=id;
		this.occupation = occupation;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.startingDate = startingDate;
		this.leavingDate = leavingDate;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.marriageStatus = marriageStatus;
	}


	


	public String getRegNo() {
		return regNo;
	}


	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getId() {
		return id;
	}


	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public LocalDate getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(LocalDate leavingDate) {
		this.leavingDate = leavingDate;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public MarriageStatus getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(MarriageStatus marriageStatus) {
		this.marriageStatus = marriageStatus;
	}


	public Occupation getOccupation() {
		return occupation;
	}

	public Gender getGender() {
		return gender;
	}

	public long getAge() {
		return age;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	
}
