package common.Enum;


public enum Gender {

ERKEK(1), KADIN(0), NO_INFO(2);
	
	int gender;
	
	private Gender(int gender) {
		this.gender = gender;
	}
	
	public static Gender stringToGender(int i) {
		if (i==0) {
			return KADIN;
		
		} else if ( i==1) {
			return ERKEK;
			
		} else {
			return NO_INFO;
		}
	}
	
	
	
	
}
