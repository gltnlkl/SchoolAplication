package course;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import common.Enum.Lesson;
import people.Student;
import people.Teacher;

public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Lesson lesson;
	private Teacher master;
	private Teacher assistant;
	private int year;
	private DayOfWeek day;
	private LocalTime startTime;
	private ArrayList<Object> myList;
	private String id;

	public Course(String id,Lesson lesson, Teacher master, Teacher assistant, int year, DayOfWeek day, LocalTime startTime,
			List<Object> student) {

		super();
		this.id= id;
		this.lesson = lesson;
		this.master = master;
		this.assistant = assistant;
		this.year = year;
		this.day = day;
		this.startTime = startTime;
		this.myList = (ArrayList<Object>) student;
	}

	@Override
	public String toString() {
		
		
		return "Course [" + id + "lesson=" + lesson + ", master=" + master.getName() + ", assistant="
				+ assistant.getName()+ ", year=" + year + ", day=" + day + ", startTime=" + startTime + ", Student="
				+ myList+ "]";
	}

	public Lesson getLesson() {
		return lesson;
	}

	public Teacher getMaster() {
		return master;
	}

	public Teacher getAssistant() {
		return assistant;
	}

	public int getYear() {
		return year;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public ArrayList<Object> getStudents() {
		return myList;
	}

	public void addStudent(Student student) {
		this.myList.add(student);
	}

	public String getId() {
		return id;
	}

}
