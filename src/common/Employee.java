package common;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import common.Enum.Gender;
import common.Enum.MarriageStatus;
import common.Enum.Occupation;

public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double startingSalary;
	private static double salary;

	protected static int numOfEmployee = 0;

	public Employee(String id,Occupation occupation, Name name, Gender gender, long age, LocalDate startingDate,
			LocalDate leavingDate, PhoneNumber phoneNumber, LocalDate birthday, MarriageStatus marriageStatus,
			double startingSalary) {
		super(id,occupation, name, gender, age, startingDate, leavingDate, phoneNumber, birthday, marriageStatus);
		this.startingSalary = startingSalary;

		this.salary();
	}

	protected double salary() {

		double salary = 0;
		int increaseNumber = 0;
		
		if (leavingDate == null) {

			increaseNumber = (int) ((this.startingDate.until(LocalDate.now(), ChronoUnit.MONTHS)) / 6);

		}else {
			
			increaseNumber = (int) ((this.startingDate.until(leavingDate, ChronoUnit.MONTHS)) / 6);
		}
		if (getOccupation() == Occupation.JANITOR) {

			for (int i = 0; i < increaseNumber; i++) {
				salary += salary * 8.5 / 100.0;
		}
			}
		else if (getOccupation() == Occupation.OFFICER) {

				for (int i = 0; i < increaseNumber; i++) {
					salary += salary * 9 / 100.0;

		}
			}
		else if (getOccupation() == Occupation.TEACHER) {

			for (int i = 0; i < increaseNumber; i++) {
				salary += salary * 10 / 100.0;
}
		}
		this.setSalary(salary);
		
		return salary;

	}

	

	private void regNoE() {

		String regNumber = String.format("%03d", ++Employee.numOfEmployee);
		if (Employee.numOfEmployee == 1000) {
			Employee.numOfEmployee = 1;
		}
		this.setRegNo("-" + regNumber);

	}

	public double getStartingSalary() {
		return startingSalary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		Employee.salary = salary;
	}
	
	
	public boolean isOldEmployee() {
		return this.getLeavingDate().isBefore(LocalDate.now());
	}

}
