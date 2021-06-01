package ex03_HashSet;
import java.util.*;

public class HashSetTest2 {
	// HashSet 저장 공간 생성 : 
		//인스턴스 저장.
		//중복 저장을 허용하지 않는다. 
		//저장 순서를 저장하지 않는다.
	
	public static void main(String[] args) {
		
//		HashSet<String> hashSet = new HashSet<>();
		Set<SimpleNumber> hashSet = new HashSet<>();
		
		//데이터 저장
//		hashSet.add("First");
//		hashSet.add("Second");
//		hashSet.add("Third");
//		hashSet.add("Fourth");
		hashSet.add(new SimpleNumber(10));
		hashSet.add(new SimpleNumber(20));
		hashSet.add(new SimpleNumber(10));
		hashSet.add(new SimpleNumber(30));
		hashSet.add(new SimpleNumber(20));
		
		
		//데이터의 일괄 처리
//		Iterator<String> itr = hashSet.iterator();
		Iterator<SimpleNumber> itr = hashSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}	
}

class SimpleNumber {
	int num;
	SimpleNumber(int num) {
		this.num = num;
	}
	public String toString() {
		return String.valueOf(num);
	}
	public int hashCode() {
		return num%3;
	}
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj != null && obj instanceof SimpleNumber) {
			SimpleNumber sNum = (SimpleNumber)obj;
			if(this.num == sNum.num) {
				result = true;
			}
		}
		return result;
	}

}


