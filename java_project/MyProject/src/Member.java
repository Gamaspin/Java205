
public class Member {
	public static void main(String[] args) {
		System.out.println("류한성");
		String name = "호날두";
		int age = 37;
		double height = 183.5d;
		float weight = 68.3f;
		boolean hasBook = false;


		System.out.println("축구 선수 " + name);	//String + String
		System.out.println("키는 " + height + "cm 입니다.");
		//String + double + String -> (String + String) + String
		//String + any Type -> String + String
		System.out.println("나이는 " + age + "살 입니다.");
		System.out.println("책의 보유 여부 : " + hasBook);

		if(hasBook) {
			System.out.println("책 있어요!");
		} else {
			System.out.println("책 없어요!");
		}
	}
}
