package people;

import java.io.Serializable;
import java.time.LocalDate;

import common.Name;
import common.Person;
import common.PhoneNumber;
import common.Enum.Gender;
import common.Enum.MarriageStatus;
import common.Enum.Occupation;

public class Student extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static int numOfStudents = 0;


	public Student(String id,Occupation occupation, Name name, Gender gender, long age, LocalDate startingDate,
			LocalDate leavingDate, MarriageStatus marriageStatus, PhoneNumber phoneNumber,
			LocalDate birthday) {
		super(id, occupation, name, gender, age, startingDate, leavingDate, phoneNumber, birthday, marriageStatus);
		

	}

	private void regNo() {

		String year = String.valueOf(this.getStartingDate().getYear());
		String regNumber = String.format("%03d", ++Student.numOfStudents);
		if (Student.numOfStudents == 1000) {
			Student.numOfStudents = 1;
		}
		this.setRegNo(year + "-" + regNumber);

	}

	@Override
	public String toString() {
		return  getOccupation()+ "[Reg No:"+ getId() + /*getRegNo() + */", Name: " + getName() + ", Gender: " + gender
				+ ", Birthday: " + getBirthday() + ",  Age: " + getAge() + ",  Starting Date:" + getStartingDate()
				+ ", Leaving Date: " + getLeavingDate() +  ", Marriage Status:" + marriageStatus
				+ ", Phone Number: " + getPhoneNumber() + "]";
	}



}
