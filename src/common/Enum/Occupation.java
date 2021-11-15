package common.Enum;

public enum Occupation {

	OFFICER(2), TEACHER(1), STUDENT(0), JANITOR(3), NO_INFO(4);

	int occupation;

	private Occupation(int occupation ) {
		this.occupation = occupation;
	}

	public static Occupation stringToOccupation(int i) {
		if (i == 0 ) {
			return STUDENT;

		} else if (i ==1) {
			return TEACHER;

		} else if (i==2) {
			return OFFICER;

		} else if (i==3) {
			return JANITOR;

		} else {
			return NO_INFO;
		}
	}

}
