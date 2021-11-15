package common.Enum;

public enum Lesson {

	MATH(0), ENGLISH(1), TURKISH(2), GEOMETRY(3), PHYSICAL(4), NO_LESSON(5);

	int lessonName;

	private Lesson(int lessonName) {

		this.lessonName = lessonName;
	}

	public static Lesson stringToLesson(int i) {
		if (i==0) {
			return MATH;

		} else if (i==1) {
			return ENGLISH;
			
		} else if (i==2) {
			return TURKISH;
			
		} else if (i==3) {
			return GEOMETRY;
			
		} else if (i==4) {
			return PHYSICAL;
			
		} else {
			return NO_LESSON;
		}
	}
}
