package ncs.MemberManager;

public class LoginInfo {

	private int idx;
	private String id;
	private String name;
	
	public LoginInfo(int idx, String id, String name) {
		this.idx = idx;
		this.id = id;
		this.name = name;
	}

	public int getIdx() {
		return idx;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	// 로그인이 되어있는 상태에서 정보가 변하면 안되기 때문에 setter는 안만듦
	
	@Override
	public String toString() {
		return "LoginInfo [회원번호= " + idx + ", 아이디= " + id + ", 이름= " + name + "]";
	}
}
