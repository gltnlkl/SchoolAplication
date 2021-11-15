package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Person;
import common.Enum.Occupation;
import course.Course;
import course.CreateCourse;
import people.Student;
import utils.GltnUtils;

public class MyMethod {

	public final String PATH = "./src/main/schoolData.txt";
	public final String PATHL = "./src/main/lessonData.txt";

	public List<Object> ListForPeople;
	public List<Object> ListForClass;

	private Map<Integer, String> menuItems() {

		Map<Integer, String> mapList = new HashMap<Integer, String>();

		mapList.put(0, "Yeni Calisan Girisi");
		mapList.put(1, "Yeni Ogrenci Girisi");
		mapList.put(2, "Calisanlar Listesi");
		mapList.put(3, "Eski Calisanlar Listesi");
		mapList.put(4, "Ogrenciler Listesi");
		mapList.put(5, "Eski Ogrenciler Listesi");
		mapList.put(6, "Yeni Sinif Olusturma");
		mapList.put(7, "Siniflari Listele");
		mapList.put(8, "Hediye Listesi");
		mapList.put(9, "Maas Listesi");
		mapList.put(10, "Ogrencinin Siniflari");
		mapList.put(11, "Uygulamadan Cikis");

		return mapList;

	}

	private void writeData(Object obj, String path) {

		if (obj != null) {

			ListForPeople.add(obj);

			GltnUtils.writeFileObj(path, ListForPeople);
		}

	}

	private void writeDataLesson(Object obj, String path) {

		if (obj != null) {

			ListForClass.add(obj);

			GltnUtils.writeFileObj(path, ListForClass);
		}

	}
	
	private void salary() {
	
		for (Object obj : ListForPeople) {
			
			
		}
		
		
		
	}


	protected void mainAction() throws InvalidMariageStatusException {

		ListForPeople = GltnUtils.readFromFileObj(PATH);

		ListForClass = GltnUtils.readFromFileObj(PATHL);

		boolean isloop = true;

		do {

			switch (utils.GltnUtils.showMenuI("OKUL YONETIM SISTEMI ", menuItems())) {

			case 0:

				System.out.println("Yeni Calisan Girisi:\n");

				CreatePerson createEmployee = new CreatePerson();

				Person thisEmployee = createEmployee.Employee();

				writeData(thisEmployee, PATH);

				break;
			case 1:

				System.out.println("Yeni Ogrenci Girisi:\n");

				CreatePerson createStudent = new CreatePerson();

				Person thisStudent = createStudent.student();

				writeData(thisStudent, PATH);

				break;
			case 2:

				System.out.println("Calisanlar Listesi");

				for (Object person : ListForPeople) {

//						if (person instanceof Person)
						if (((Person) person).getLeavingDate() == null
								&& ((Person) person).getOccupation() != Occupation.STUDENT)

							System.out.println(person);
				}
				GltnUtils.readString("Devam etmek icin bir tusa basiniz.");
				break;
			case 3:

				System.out.println("Eski Calisan Listesi");

				for (Object person : ListForPeople) {
					//	if (person instanceof Person)
						if (((Person) person).getLeavingDate() != null
								&& ((Person) person).getOccupation() != Occupation.STUDENT)

							System.out.println(person);
				}
				GltnUtils.readString("Devam etmek icin bir tusa basiniz.");
				break;
			case 4:

				System.out.println("Ogrenci Listesi");

				for (Object person : ListForPeople) {
				//	if (obj instanceof Student)
						if (((Person) person).getLeavingDate() == null
								&& ((Person) person).getOccupation() == Occupation.STUDENT)

							System.out.println(person);
				}
				GltnUtils.readString("Devam etmek icin bir tusa basiniz.");
				break;
			case 5:

				System.out.println("Eski Ogrenci Listesi");

				for (Object person : ListForPeople) {

					if (((Person) person).getLeavingDate() != null && ((Person) person).getOccupation() == Occupation.STUDENT)

						System.out.println(person);
				}
				GltnUtils.readString("Devam etmek icin bir tusa basiniz.");
				break;
			case 6:

				System.out.println("Yeni Sinif Olusturma");

				CreateCourse createClass = new CreateCourse();

				Course thisClass = createClass.createClass();

				writeDataLesson(thisClass, PATHL);

				break;
			case 7:

				System.out.println("Siniflari Listele");

				for (Object lesson : ListForClass) {

					System.out.println(lesson);
				}
				GltnUtils.readString("Devam etmek icin bir tusa basiniz.");
				break;
			case 8:

				System.out.println();
				break;
			case 9:

				System.out.println("Maas Listesi");
				salary();
				break;

			case 10:
				System.out.println("Ogrencinin Siniflari");
				
				for (Object lesson : ListForClass) {

					System.out.println(lesson);
				}
				
				
				break;
			case 11:

				System.out.println("Sistemden Cikiliyor.\nIyi Gunler Dileriz.");
				isloop = false;
				break;

			}
		} while (isloop);

	}

	
}
