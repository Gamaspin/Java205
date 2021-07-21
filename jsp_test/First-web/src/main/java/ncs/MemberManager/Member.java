package ncs.MemberManager;

import java.sql.Date;
import java.sql.Timestamp;

public class Member {
	private int idx;
	private String id;
	private String pw;
	private String name;
	private Timestamp regDate;
	
	public Member() {}
	public Member(int idx, String id, String pw, String name) {
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
		public Member(int idx, String id, String pw, String name, Timestamp regDate) {
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.regDate = regDate;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
	return "Member [id=" + id + ", pw=" + pw+ ", name=" + name + ", regDate=" + regDate + "]";
	}
}
