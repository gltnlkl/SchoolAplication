package people;

import java.io.Serializable;
import java.time.LocalDate;

import common.Employee;
import common.Name;
import common.PhoneNumber;
import common.Enum.Gender;
import common.Enum.MarriageStatus;
import common.Enum.Occupation;


public class Janitor extends Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Janitor(String id,Occupation occupation, Name name, Gender gender, long age, LocalDate startingDate,
			LocalDate leavingDate, PhoneNumber phoneNumber, LocalDate birthday, double startingSalary,
			MarriageStatus marriageStatus) {
		super(id, occupation, name, gender, age, startingDate, leavingDate, phoneNumber, birthday, marriageStatus,
				startingSalary);
	
	}

	@Override
	public String toString() {
		return getOccupation() + " [ RegNo: " + getId() + /*getRegNo() +*/ " ," + getName()
				+ " , gender :" + gender + " , Birthday: " + getBirthday() + " , Age:" + getAge() + " , StartingDate: "
				+ getStartingDate() + ", LeavingDate: " + getLeavingDate() + " , marriageStatus: " + marriageStatus
				+ " , StartingSalary: " + getStartingSalary()+ " ," + getPhoneNumber() + " Salary: " + getSalary()+ " ]";
	}
	
	
	

}
