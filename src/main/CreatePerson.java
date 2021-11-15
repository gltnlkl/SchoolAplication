package main;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Name;
import common.Person;
import common.PhoneNumber;
import common.Enum.Gender;
import common.Enum.MarriageStatus;
import common.Enum.Occupation;
import people.Janitor;
import common.Enum.Lesson;
import people.Officer;
import people.Student;
import people.Teacher;


public class CreatePerson {

	private Map<Integer, String> occupationItems() {

		Map<Integer, String> mapList = new HashMap<Integer, String>();

		mapList.put(0, "Ogretmen ");
		mapList.put(1, "Memur ");
		mapList.put(2, "Hademe ");
		mapList.put(3, "Baska bir islem ");

		return mapList;

	}

	private Map<Integer, String> genderItems() {

		Map<Integer, String> mapList = new HashMap<Integer, String>();

		mapList.put(0, "Kadin ");
		mapList.put(1, "Erkek ");
		mapList.put(2, "No info ");

		return mapList;

	}


	private static Map<Integer, String> mariageStatusItems() {

		Map<Integer, String> mapList = new HashMap<Integer, String>();

		mapList.put(0, "Evli");
		mapList.put(1, "Bekar");
		mapList.put(2, "No Info");

		return mapList;
	}

	private Name name() {

		Name name = new Name(utils.GltnUtils.readFString("\nLutfen isim giriniz.\n"),
				utils.GltnUtils.readFString("\nLutfen Soy isim giriniz.\n"),
				utils.GltnUtils.readFString("\nLutfen var ise ikinci isim giriniz.\n"));
		return name;
	}

	private int gender() {
		int gender = utils.GltnUtils.basicMenuI("\nLutfen cinsiyet icin secim yapiniz\n", genderItems());
		return gender;
	}

	private String birthDate() {

		String birthDate = utils.GltnUtils.readBirthDate();
		return birthDate;
	}

	private LocalDate startingDate() {
		LocalDate startingDate = utils.GltnUtils.readDate("\nLutfen baslama");
		return startingDate;
	}

	private LocalDate leavingDate() {
		LocalDate leavingDate = utils.GltnUtils.readDate("\nLutfen ayrilma");
		return leavingDate;
	}



	private int mariageStatus() {

		int mariageStatus = 0;
		try {
			mariageStatus = utils.GltnUtils.basicMenuI("\nLutfen medeni hali giriniz.\n", mariageStatusItems());
		} catch (Exception e) {

		}
		return mariageStatus;

	}

	private PhoneNumber phoneNumberE() {

		PhoneNumber phoneNumberE = new PhoneNumber(utils.GltnUtils.readInt("\nLutfen 1. telefon numarasini giriniz.\n"),
				utils.GltnUtils.readInt("\nLutfen 2. telefon numarasini giriniz.\n"));

		return phoneNumberE;

	}

	private double startingSalaryE() {

		double startingSalaryE = utils.GltnUtils.readDouble("\nLutfen ise baslangic maasini giriniz.");

		return startingSalaryE;

	}


	protected Person Employee() {

		boolean isloop = true;

		do {

			switch (utils.GltnUtils.showMenuI("\nLutfen sisteme giris yapmak icin brans seciniz.\n",
					occupationItems())) {
			case 0:

				return teacher();

			case 1:

				return officer();
			case 2:

				return janitor();
			case 3:

				isloop = false;
				break;

			default:
				System.out.println("\nLutfen verilen degerlerden bir secim yapiniz.\n");
			}
		} while (isloop);
		
		return null;

	

	}

	protected Person student() {
		
		
		
		Name nameS = name();

		int genderS = gender();

		String birthDateS = birthDate();

		long ageS = utils.GltnUtils.readAge(birthDateS);

		LocalDate dateOfBirthDateS = utils.GltnUtils.stringToDate(birthDateS);

		LocalDate startingDateS = startingDate();

		LocalDate leavingDateS = leavingDate();

	

		int mariageStatusS = 0;
		boolean loopS = true;

		while (loopS) {
			try {
				mariageStatusS = mariageStatus();

				loopS = false;
				if (mariageStatusS != 1) {
					throw new InvalidMariageStatusException("\nOgrenciler evli olamaz.\n");
				}
			} catch (InvalidMariageStatusException ie) {

				System.out.println(ie.getMessage());
				System.out.println();

				loopS = true;

			}
		}

		PhoneNumber phoneNumberS = new PhoneNumber(utils.GltnUtils.readInt("\nLutfen 1. telefon numarasini giriniz.\n"),
				utils.GltnUtils.readInt("\nLutfen 2. telefon numarasini giriniz.\n"),
				utils.GltnUtils.readInt("\nLutfen ebeveyn telefon numarasini giriniz.\n"));

		String id="S";
		
		Student student = new Student(id,Occupation.STUDENT, nameS, Gender.stringToGender(genderS),
				ageS, startingDateS, leavingDateS,
				MarriageStatus.stringToMarriageStatus(mariageStatusS), phoneNumberS, dateOfBirthDateS);

		System.out.println("\n\n\nOgrenci kaydi olusturuldu.\n\n\n");
		System.out.println(student);
		System.out.println("\n\n\n");

		return student;

	}

	private Person teacher() {

		Name nameT = name();

		int genderT = gender();

		String birthDateT = birthDate();

		long ageT = utils.GltnUtils.readAge(birthDateT);

		LocalDate dateOfBirthDateT = utils.GltnUtils.stringToDate(birthDateT);

		LocalDate startingDateT = startingDate();

		LocalDate leavingDateT = leavingDate();


		int mariageStatusT = mariageStatus();

		PhoneNumber phoneNumberEt = phoneNumberE();

		double startingSalaryEt = startingSalaryE();

		String id="T";
		
		Teacher teacher = new Teacher(id,Occupation.TEACHER, nameT, Gender.stringToGender(genderT),
				ageT, startingDateT, leavingDateT,
				MarriageStatus.stringToMarriageStatus(mariageStatusT), phoneNumberEt, dateOfBirthDateT,
				startingSalaryEt);

		System.out.println("\n\n\nOgretmen kaydi olusturuldu.\n\n\n");
		System.out.println(teacher);	
		System.out.println("\n\n\n");

		return teacher;

	}

	private Person officer() {

		Name nameO = name();

		int genderO = gender();

		String birthDaterO = birthDate();

		long ageO = utils.GltnUtils.readAge(birthDaterO);

		LocalDate dateOfBirthDateO = utils.GltnUtils.stringToDate(birthDaterO);

		LocalDate startingDateO = startingDate();

		LocalDate leavingDateO = leavingDate();

		int mariageStatusO = mariageStatus();

		PhoneNumber phoneNumberEo = phoneNumberE();

		double startingSalaryEo = startingSalaryE();

		String id="O";
		
		Officer officer = new Officer(id,Occupation.OFFICER, nameO, Gender.stringToGender(genderO),
				ageO, startingDateO, leavingDateO, phoneNumberEo, dateOfBirthDateO, startingSalaryEo,
				MarriageStatus.stringToMarriageStatus(mariageStatusO));

		System.out.println("\n\n\nMemur kaydi olusturuldu.\n\n\n");
		System.out.println(officer);
		System.out.println("\n\n\n");

		return officer;

	}

	private Person janitor() {

		Name nameJ = name();

		int genderJ = gender();

		String birthDaterJ = birthDate();

		long ageJ = utils.GltnUtils.readAge(birthDaterJ);

		LocalDate dateOfBirthDateJ = utils.GltnUtils.stringToDate(birthDaterJ);

		LocalDate startingDateJ = startingDate();

		LocalDate leavingDateJ = leavingDate();

		int mariageStatusJ = mariageStatus();

		PhoneNumber phoneNumberEj = phoneNumberE();

		double startingSalaryEj = startingSalaryE();

		String id="J";
		
		Janitor janitor = new Janitor(id, Occupation.JANITOR, nameJ, Gender.stringToGender(genderJ),
				ageJ, startingDateJ, leavingDateJ, phoneNumberEj, dateOfBirthDateJ, startingSalaryEj,
				MarriageStatus.stringToMarriageStatus(mariageStatusJ));

		System.out.println("\n\n\nHademe kaydi olusturuldu.\n\n\n");
		System.out.println(janitor);
		System.out.println("\n\n\n");

		return janitor;
	}
}
