package course;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Person;
import common.Enum.Lesson;
import common.Enum.Occupation;
import main.MyMethod;
import people.Teacher;
import utils.GltnUtils;

public class CreateCourse {

	private Map<Integer, String> lessonItems() {

		Map<Integer, String> mapList = new HashMap<Integer, String>();

		mapList.put(0, "Matematik");
		mapList.put(1, "Ingilizce ");
		mapList.put(2, "Turkce");
		mapList.put(3, "Geometri ");
		mapList.put(4, "Fizik ");
		mapList.put(5, "No Lesson");

		return mapList;
	}

	private int lesson() {

		int lesson = utils.GltnUtils.basicMenuI("\nLutfen ders icin secim yapiniz.\n", lessonItems());
		return lesson;

	}

	private int classDate() {
		int year = 0;
		boolean loop = true;

		while (loop) {
			try {

				LocalDate classDate = utils.GltnUtils.readDate("\nLutfen ders");
				year = classDate.getYear();
				loop = false;
				return year;

			} catch (NullPointerException ne) {

				loop = true;
			} catch (Exception e) {

				loop = true;
			}
		}
		return year;
	}

	private int dayOfWeek() {

		int dayOfWeek = 0;
		boolean loop = true;

		while (loop) {
			try {

				dayOfWeek = GltnUtils.readInt(
						"\nLutfen ders gununu 1-7 aralaginda bir sayi olarak giriniz.\n( Pazartesi icin 1 ) (Pazar icin - 7) gibi");

				if (dayOfWeek < 8 || dayOfWeek > 0) {

					return dayOfWeek;
				}

				else {

					throw new WrongDayNumberException("\nLutfen 1-7 arasi bir değer giriniz.\n");

				}
			} catch (WrongDayNumberException ie) {

				System.out.println(ie.getMessage());
				System.out.println();
				loop = true;
			}

		}
		return dayOfWeek;

	}

	public Teacher classTeacher(String str) {

		MyMethod method = new MyMethod();

		method.ListForPeople = GltnUtils.readFromFileObj(method.PATH);

		for (Object obj : method.ListForPeople) {

			if (((Person) obj).getOccupation() == Occupation.TEACHER)

				System.out.println(((Person) obj).getName());

		}

		String name = GltnUtils.readString("\nLutfen " + str + " ogretmen isim giriniz");
		String lastName = GltnUtils.readString("\nLutfen " + str + " ogretmen soyisim giriniz");

		Teacher classTeacher = null;

		for (Object obj : method.ListForPeople) {

			if (((Person) obj).getName().getFirstName().equalsIgnoreCase(name)
					&& ((Person) obj).getName().getLastName().equalsIgnoreCase(lastName))

				classTeacher = (Teacher) obj;

			return classTeacher;
		}
		return classTeacher;

	}

	private static List<Object> studentClassList() {

		MyMethod method = new MyMethod();

		List<Object> myList = GltnUtils.readFromFileObj(method.PATH);

		for (Object obj : myList) {

			if (((Person) obj).getOccupation() == Occupation.STUDENT)

				System.out.println(((Person) obj).getName());

		}

		boolean loop = true;

		while (loop) {

			String name = GltnUtils.readString("Lutfen ogrenci isim giriniz");
			String lastName = GltnUtils.readString("Lutfen ogrenci soyisim giriniz");

			for (Object person : method.ListForPeople) {

				if (((Person) person).getName().getFirstName().equalsIgnoreCase(name)
						&& ((Person) person).getName().getLastName().equalsIgnoreCase(lastName))

					method.ListForClass.add(person);

			}

			int exitInput = GltnUtils.readInt("\nYeni ogrenci eklemek icin (1) e, baska bir islem icin (0) a basiniz");

			if (exitInput == 0) {

				loop = false;

			} else if (exitInput == 1) {

				loop = true;

			} else {

				System.out.println("Lutfen belirtilen degerlerden giris yapiniz. ");
			}
		}
		return method.ListForClass;

	}

	public Course createClass() {

		boolean isloop = false;
		int exitInput = 0;

		do {

			MyMethod method = new MyMethod();

			method.ListForPeople = GltnUtils.readFromFileObj(method.PATH);

			int lesson = lesson();

			LocalTime time = GltnUtils.readTime();

			int year = classDate();

			Teacher teacherMaster = classTeacher("Master");

			Teacher teacherAsistant = classTeacher("Asistant");

			String id = "C";

			List<Object> student = studentClassList();

			Course course = new Course(id, Lesson.stringToLesson(lesson), teacherMaster, teacherAsistant, year,
					DayOfWeek.of(dayOfWeek()), time, student);

			System.out.println("\n\n\nSinif olusturuldu.\n\n\n");
			System.out.println(course);
			System.out.println("\n\n\n");

			exitInput = GltnUtils

					.readInt("Lutfen yeni sinif olusturmak icin (1) e, baska bir islem icin (0) a basiniz.");

			if (exitInput == 1)

				isloop = false;

			else if (exitInput == 0)

				isloop = true;

			return course;

		} while (isloop);

	}

	public static void main(String[] args) {

	}
}
