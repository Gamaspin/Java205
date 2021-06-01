package ex03_HashSet;
import java.util.*;

public class HashSetTest {
	// HashSet 저장 공간 생성 : 
		//인스턴스 저장.
		//중복 저장을 허용하지 않는다. 
		//저장 순서를 저장하지 않는다.
	
	public static void main(String[] args) {
		
//		HashSet<String> hashSet = new HashSet<>();
		HashSet<Integer> hashSet1 = new HashSet<>();
		
		//데이터 저장
//		hashSet.add("First");
//		hashSet.add("Second");
//		hashSet.add("Third");
//		hashSet.add("Fourth");
		hashSet1.add(1);
		hashSet1.add(2);
		hashSet1.add(1);
		hashSet1.add(3);
		hashSet1.add(2);
		
		
		//데이터의 일괄 처리
//		Iterator<String> itr = hashSet.iterator();
		Iterator<Integer> itr2 = hashSet1.iterator();
		
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		
	}
	
	
	
}
