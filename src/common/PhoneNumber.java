package common;

import java.io.Serializable;

public class PhoneNumber implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long phoneNum1;
	private long pnoneNum2;
	private long phoneNum3;
	
	
	
	public PhoneNumber(long phoneNum1, long phoneNum2, long phoneNum3) {
		super();
		this.phoneNum1 = phoneNum1;
		this.pnoneNum2 = phoneNum2;
		this.phoneNum3 = phoneNum3;
	}

	public PhoneNumber(long phoneNum1, long phoneNum2) {
		super();
		this.phoneNum1 = phoneNum1;
		this.pnoneNum2 = phoneNum2;
		this.phoneNum3 = 0;
	}


	@Override
	public String toString() {
		return "[phoneNum1=" + phoneNum1 + ", pnoneNum2=" + pnoneNum2 + ", pnoneNum3=" + phoneNum3 + "]";
	}

	public long getPnoneNum1() {
		return phoneNum1;
	}

	public void setPnoneNum1(long phoneNum1) {
		this.phoneNum1 = phoneNum1;
	}

	public long getPnoneNum2() {
		return pnoneNum2;
	}

	public void setPnoneNum2(long phoneNum2) {
		this.pnoneNum2 = phoneNum2;
	}

	public long getPnoneNum3() {
		return phoneNum3;
	}

	public void setPnoneNum3(long phoneNum3) {
		this.phoneNum3 = phoneNum3;
	}
	
	
	
	
}
