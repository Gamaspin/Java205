package guest.domain;


// 사용자로부터 데이터를 받는 클래스
public class MessageRequest {

	private String guestname;
	private String password;
	private String message;
	
	public String getGuestname() {
		return guestname;
	}
	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * public MessageRequest() {}
	 * 
	 * public MessageRequest(String guestname, String password, String message) {
	 * this.guestname = guestname; this.password = password; this.message = message;
	 * }
	 */
	
	
	@Override
	public String toString() {
		return "MessageRequest [guestname=" + guestname + ", password=" + password + ", message=" + message + "]";
	}
	
	
	// MessageRequest => Message
	public Message toMessage() {
		return new Message(guestname, password, message);
	}
	
	
	
	
}
