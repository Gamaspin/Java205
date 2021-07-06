package oneBitClass;

import java.util.Date;

public class ClassMember { 	
				// 회원이 입력 데이터를 넣어서 가입 및 관리

	 private int mno; // 회원 번호
	 private String mid; // 회원 ID
	 private String mpw; // 비밀번호
	 private String mname; // 이름
	 private String mdate;	// 생년 월일
	 private String loc; // 선호 지역
	 private int mpoint; // 보유 포인트
	 
	 public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}


	 public ClassMember(int mno, String mid, String mpw, String mname, String loc, String mdate) {
		 this.mno = mno;
		 this.mid = mid;
		 this.mpw = mpw;
		 this.mname = mname;
		 this.loc = loc;
		 this.mdate = mdate;
		 mpoint = 0;
	 }

	public ClassMember(String mpw, String loc, String mdate, String mid) {
		this.mid = mid;
		this.mpw = mpw;
		this.loc = loc;
		this.mdate = mdate;
	}

}